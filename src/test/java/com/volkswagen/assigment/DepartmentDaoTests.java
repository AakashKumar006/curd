package com.volkswagen.assigment;

import com.volkswagen.assigment.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class DepartmentDaoTests {

    @Autowired
    private DepartmentDao departmentDao;
}
