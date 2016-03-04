package yeshow.reservation;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class DynamicUpdateDBBean{
		private static DynamicUpdateDBBean instance=new DynamicUpdateDBBean();
		
		public static DynamicUpdateDBBean getInstance() {
			return instance;
		}
		
		private DynamicUpdateDBBean(){
			}
		
		private Connection getConnection() throws Exception{
			Context initCtx=new InitialContext();
			Context envCtx=(Context) initCtx.lookup("java:comp/env");
			DataSource ds=(DataSource)envCtx.lookup("jdbc/ajaxtest");
			return ds.getConnection();
		}
		
		public int getReservationCount()
		throws Exception{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			int x=0;
			
			try{
				conn=getConnection();
				
				pstmt=conn.prepareStatement("select count(*) from reservationView");
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					x=rs.getInt(1);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(rs!=null)try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
				if(conn!=null)try{conn.close();}catch(SQLException ex){}
		}
			return x;
			}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List getReservation_list(int start,int end)
		throws Exception{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List reservation_list=null;
			
			try{
				conn=getConnection();
				
				pstmt=conn.prepareStatement("select * from reservationView");

				rs=pstmt.executeQuery();
				
				if(rs.next()){
					reservation_list=new ArrayList(end);
					do{
						DynamicUpdateDataBean reservation=new DynamicUpdateDataBean();
						
						reservation.setReservation_time(rs.getString("reservation_time"));
						reservation.setServer_name(rs.getString("server_name"));
						reservation.setUser_name(rs.getString("user_name"));
						reservation.setReservation_etc(rs.getString("reservation_etc"));
						
						reservation_list.add(reservation);
					}while(rs.next());
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(rs!=null)try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
				if(conn!=null)try{conn.close();}catch(SQLException ex){}
			}
			return reservation_list;
		}
}
	


	