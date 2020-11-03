package com.wadhara.athena;

import java.sql.*;
import java.util.Properties;

import static com.wadhara.athena.AthenaConstants.*;

public class AthenaQueryExecutor {

    public void execute(){
        Properties props = new Properties();
        Connection conn = null;
        Statement statement = null;
        try{
            setProperties(props);
            //load driver class
            Class.forName(DRIVER_CLASS);
            conn = DriverManager.getConnection(connectionUrl, props);
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(QUERY);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();

            while(rs.next()){
                System.out.println(rs.getString(1) + "\t" +
                        rs.getString(2) + "\t" +
                        rs.getString(3));
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{if(conn != null) conn.close();}catch (Exception e){}
            try{if(statement != null) statement.close();}catch (Exception e){}
        }
    }

    private void setProperties(Properties properties){
        //set System properties

        System.setProperty("aws.accessKeyId", AWS_ACCESS_KEY);
        System.setProperty("aws.secretKey", AWS_SECRET_KEY);
        //set Athena props
        properties.setProperty("S3OutputLocation", s3OutputLocation);
        properties.setProperty("AwsCredentialsProviderClass", "com.simba.athena.amazonaws.auth.SystemPropertiesCredentialsProvider");
    }

}
