package com.example.students.repositories;

import com.example.students.models.StudentEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockRepo implements IStudentRepository{
    @Override
    public <S extends StudentEntity> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends StudentEntity> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends StudentEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends StudentEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends StudentEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends StudentEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends StudentEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends StudentEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends StudentEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends StudentEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends StudentEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<StudentEntity> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<StudentEntity> findAll() {
        return null;
    }

    @Override
    public List<StudentEntity> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(StudentEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends StudentEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<StudentEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<StudentEntity> findAll(Pageable pageable) {
        return null;
    }
}
