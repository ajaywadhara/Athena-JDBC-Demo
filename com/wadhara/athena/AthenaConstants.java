package com.wadhara.athena;

public interface AthenaConstants {
    String AWS_ACCESS_KEY = "AKIAI6UZQZGMBPVDQAOQ";
    String AWS_SECRET_KEY = "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";
    String connectionUrl = "jdbc:awsathena://AwsRegion=us-east-1";
    String s3OutputLocation = "s3://ajay-athena-lab/athena-output/";
    String QUERY = "SELECT count(station) AS Num_of_stations,\n" +
            "         fuel,\n" +
            "         state\n" +
            "FROM \"mydatabase\".\"electricity\"\n" +
            "WHERE year= '2016'\n" +
            "        AND fuel='COAL'\n" +
            "GROUP BY  fuel, state;";
    String DRIVER_CLASS = "com.simba.athena.jdbc.Driver";
}
