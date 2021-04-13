package com.example.dothihonghanh.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dothihonghanh.entity.Product;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM Product")
    List<Product> getAll();

    @Query("SELECT * FROM Product WHERE id = :id")
    Product getProduct(int id);

    @Insert(onConflict = REPLACE)
    void Insert(Product product);

    @Update
    void Update(Product product);

    @Delete
    void Delete(Product product);
}
