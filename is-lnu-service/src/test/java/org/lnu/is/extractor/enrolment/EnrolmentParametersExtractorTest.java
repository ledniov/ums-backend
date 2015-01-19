package org.lnu.is.extractor.enrolment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.dao.dao.Dao;
import org.lnu.is.domain.common.RowStatus;
import org.lnu.is.domain.department.Department;
import org.lnu.is.domain.enrolment.Enrolment;
import org.lnu.is.domain.enrolment.EnrolmentType;
import org.lnu.is.domain.person.Person;
import org.lnu.is.domain.person.PersonPaper;
import org.lnu.is.domain.specoffer.SpecOffer;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EnrolmentParametersExtractorTest {

	@Mock
	private Dao<Person, Long> personDao;

	@Mock
	private Dao<SpecOffer, Long> specOfferDao;

	@Mock
	private Dao<Department, Long> departmentDao;

	@Mock
	private Dao<PersonPaper, Long> personPaperDao;

	@Mock
	private Dao<EnrolmentType, Long> enrolmentTypeDao;

	@Mock
	private Dao<Enrolment, Long> enrolmentDao;

	@InjectMocks
	private EnrolmentParametersExtractor unit;

	@Test
	public void testGetParameters() throws Exception {
		// Given
		String docNum = "1213344";

		Long personId = 1L;
		Person person = new Person();
		person.setId(personId);
		
		Long specOfferId = 2L;
		SpecOffer specOffer = new SpecOffer();
		specOffer.setId(specOfferId);
		
		Long personPaperId = 3L;
		PersonPaper personPaper = new PersonPaper();
		personPaper.setId(personPaperId);
		
		Long enrolmentTypeId = 4L;
		EnrolmentType enrolmentType = new EnrolmentType();
		enrolmentType.setId(enrolmentTypeId);
		
		Long parentId = 5L;
		Enrolment parent = new Enrolment();
		parent.setId(parentId);
		
		Long departmentId = 6L;
		Department department = new Department();
		department.setId(departmentId);
		
		Double mark = 2.1;
		String docSeries = "doc series";
		String docText = "doc text";
		Integer isState = 1;
		Integer isHostel = 2;
		Integer isPrivilege = 3;
		Date evDate = new Date();
		Date begDate = new Date();
		Date endDate = new Date();

		Enrolment entity = new Enrolment();
		entity.setPerson(person);
		entity.setSpecOffer(specOffer);
		entity.setDepartment(department);
		entity.setPersonPaper(personPaper);
		entity.setEnrolmentType(enrolmentType);
		entity.setParent(parent);
		
		entity.setMark(mark);
		entity.setDocSeries(docSeries);
		entity.setDocNum(docNum);
		entity.setDocText(docText);
		entity.setIsState(isState);
		entity.setIsHostel(isHostel);
		entity.setIsPrivilege(isPrivilege);
		entity.setEvDate(evDate);
		entity.setBegDate(begDate);
		entity.setEndDate(endDate);

		Map<String, Object> expected = new HashMap<String, Object>();
		expected.put("person", person);
		expected.put("specOffer", specOffer);
		expected.put("department", department);
		expected.put("personPaper", personPaper);
		expected.put("enrolmentType", enrolmentType);
		expected.put("parent", parent);
		expected.put("mark", mark);
		expected.put("docSeries", docSeries);
		expected.put("docNum", docNum);
		expected.put("docText", docText);
		expected.put("isState", isState);
		expected.put("isHostel", isHostel);
		expected.put("isPrivilege", isPrivilege);
		expected.put("evDate", evDate);
		expected.put("begDate", begDate);
		expected.put("endDate", endDate);
		expected.put("status", RowStatus.ACTIVE);
		// When
		when(personDao.getEntityById(anyLong())).thenReturn(person);
		when(specOfferDao.getEntityById(anyLong())).thenReturn(specOffer);
		when(departmentDao.getEntityById(anyLong())).thenReturn(department);
		when(personPaperDao.getEntityById(anyLong())).thenReturn(personPaper);
		when(enrolmentTypeDao.getEntityById(anyLong())).thenReturn(enrolmentType);
		when(enrolmentDao.getEntityById(anyLong())).thenReturn(parent);
		
		Map<String, Object> actual = unit.getParameters(entity);

		// Then
		verify(personDao).getEntityById(anyLong());
		verify(specOfferDao).getEntityById(specOfferId);
		verify(departmentDao).getEntityById(departmentId);
		verify(personPaperDao).getEntityById(personPaperId);
		verify(enrolmentTypeDao).getEntityById(enrolmentTypeId);
		verify(enrolmentDao).getEntityById(parentId);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetParametersWithDefaultEntity() throws Exception {
		// Given
		Enrolment entity = new Enrolment();
		Map<String, Object> expected = new HashMap<String, Object>();
		expected.put("status", RowStatus.ACTIVE);
		// When
		Map<String, Object> actual = unit.getParameters(entity);

		// Then
		assertEquals(expected, actual);
	}
}

