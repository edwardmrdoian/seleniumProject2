package DatabaseObjects;

import java.sql.*;

public class DB_Methods {
    static ResultSet resultSet = null;
    static int studentId = 0;
    static String name,lastname,email,password,phone,address,city,state;
    static int zip;

    public static void InsertUsers(String name,String lastname,String email,String password,
                                   String phone,String address,String city,String state,int zip){
        String insert = "USE [Users] insert into [dbo].[users] " +
                "values(?,?,?,?,?,?,?,?,?)";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)
        ){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastname);
            preparedStatement.setString(3,phone);
            preparedStatement.setString(4,password);
            preparedStatement.setString(5,address);
            preparedStatement.setString(6,email);
            preparedStatement.setString(7,state);
            preparedStatement.setString(8,city);
            preparedStatement.setInt(9,zip);

            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected ==1){
                System.out.println(String.format("Row affected %d", rowAffected));
                resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next()){
                    studentId=resultSet.getInt(1);
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(resultSet != null)  resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getName() {
        return name;
    }

    public static String getLastname() {
        return lastname;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getPhone() {
        return phone;
    }

    public static String getAddress() {
        return address;
    }

    public static String getCity() {
        return city;
    }

    public static String getState() {
        return state;
    }

    public static int getZip() {
        return zip;
    }

    public static void SelectLastUser(){

        String select ="USE [Users] select * from [dbo].[users] " +
                "where id="+studentId;
        try(Connection connection = DBConnection.getConnection())
        {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(select);
            if (resultSet.next()){
                name = resultSet.getString("firstName");
                lastname = resultSet.getString("lastName");
                phone = resultSet.getString("phone");
                password = resultSet.getString("password");
                address = resultSet.getString("address");
                email = resultSet.getString("email");
                state = resultSet.getString("state");
                city = resultSet.getString("city");
                zip = resultSet.getInt("zip");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(resultSet != null)  resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
