package com.example.android_sqldatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.android_sqldatabase.entity.User;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE id = :id")
    User getUser(int id);

    @Query("SELECT * FROM User WHERE id = :id")
     List<User> findUser(int id);

    @Insert(onConflict = REPLACE)
    void Insert(User user);

    @Update
    void Update(User user);

    @Delete
    void Delete(User user);
}
