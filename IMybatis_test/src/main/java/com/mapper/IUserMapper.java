package com.mapper;

import com.User;

import java.util.List;

public interface IUserMapper {
    public <T>List<T> findOne(User user);
    public void createOne(User user);
    public void updateOne(User user);
    public void deleteOne(User user);
}
