package com.edusys.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ChuyenDeDAOTest.class, ChuyenDeTest.class, HocVienDAOTest.class, HocVienTest.class,
		KhoaHocDAOTest.class, KhoaHocTest.class, NguoiHocDAOTest.class, NguoiHocTest.class, NhanVienDAOTest.class,
		NhanVienTest.class })
public class AllTests {

}
