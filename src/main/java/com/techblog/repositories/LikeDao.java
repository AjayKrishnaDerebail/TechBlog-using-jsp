package com.techblog.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDao {
    Connection connection;

    public LikeDao(Connection connection){
        this.connection=connection;
    }
    public boolean insertLike(int postId,int userId){
        boolean flag=false;

        @SuppressWarnings("SqlNoDataSourceInspection")
        String q = "insert into likes(postId,userId) values(?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(q);
            statement.setInt(1, postId);
            statement.setInt(2, userId);
            statement.executeUpdate();
            flag=true;
        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return flag;
    }

    public int countLikeOnPost(int postId){
        int count = 0;
        @SuppressWarnings("SqlNoDataSourceInspection")
        String q = "select count(*) from likes where postId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(q);
            statement.setInt(1,postId);
            ResultSet set = statement.executeQuery();
            while(set.next()){
                count = set.getInt("count(*)");
            }
        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        return count;
    }

    public boolean isLikedByUser(int postId, int userId) {
        boolean f = false;
        try {
            @SuppressWarnings("SqlNoDataSourceInspection")
            String query = "select * from likes where postId=? and userId=?";
            PreparedStatement p = this.connection.prepareStatement(query);
            p.setInt(1, postId);
            p.setInt(2, userId);
            ResultSet set = p.executeQuery();
            if (set.next()) {
                f = true;
            }

        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return f;
    }

    public boolean deleteLike(int postId, int userId) {
        boolean f = false;
        try {
            @SuppressWarnings("SqlNoDataSourceInspection")
            String query = "delete from likes where postId=? and userId=?";
            PreparedStatement p = this.connection.prepareStatement(query);
            p.setInt(1, postId);
            p.setInt(2, userId);
            p.executeUpdate();
            f = true;
        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        return f;
    }
}
