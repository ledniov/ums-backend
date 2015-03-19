package org.lnu.is.dao.builder.order;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.lnu.is.domain.asset.Asset;
import org.lnu.is.domain.department.Department;
import org.lnu.is.domain.employee.Employee;
import org.lnu.is.domain.optype.OperationType;
import org.lnu.is.domain.order.Order;
import org.lnu.is.domain.order.type.OrderType;
import org.lnu.is.domain.partner.Partner;
import org.lnu.is.domain.reason.Reason;
import org.lnu.is.pagination.MultiplePagedSearch;

public class OrderQueryBuilderTest {

	private OrderQueryBuilder unit = new OrderQueryBuilder();
	
	private Boolean active = true;
	private Boolean security = true;
	
	@Before
	public void setup() {
		unit.setActive(active);
		unit.setSecurity(security);
	}

	@Test
	public void testBuild() throws Exception {
		// Given
		Order context = new Order();

		String expected = "SELECT e FROM Order e WHERE e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		MultiplePagedSearch<Order> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);

		// Then
		assertEquals(expected, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledSecurityCOnstraint() throws Exception {
		// Given
		unit.setSecurity(false);
		Order context = new Order();
		
		String expected = "SELECT e FROM Order e WHERE e.status=:status ";
		MultiplePagedSearch<Order> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expected, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledStatusConstraint() throws Exception {
		// Given
		unit.setActive(false);
		
		Order context = new Order();
		
		String expected = "SELECT e FROM Order e WHERE e.crtUserGroup IN (:userGroups) ";
		MultiplePagedSearch<Order> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expected, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledDefaultConstraint() throws Exception {
		// Given
		unit.setActive(false);
		unit.setSecurity(false);
		
		Order context = new Order();
		
		String expected = "SELECT e FROM Order e ";
		MultiplePagedSearch<Order> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expected, actualQuery);
	}
	
	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		OrderType orderType = new OrderType();
		Employee employee = new Employee();
		Asset asset = new Asset();
		Partner partner = new Partner();
		OperationType opType = new OperationType();
		Department department = new Department();
		Reason reason = new Reason();
		Order parent = new Order();
		String reasonText = "fsdfsd";
		String docSeries = "fdsfds";
		String docNum = "fsdfds";
		Date docDate = new Date();
		String docIssued = "fdfds";
		Date evDate = new Date();
		
		Order context = new Order();
		context.setOrderType(orderType);
		context.setEmployee(employee);
		context.setAsset(asset);
		context.setPartner(partner);
		context.setOpType(opType);
		context.setDepartment(department);
		context.setReason(reason);
		context.setParent(parent);
		context.setReasonText(reasonText);
		context.setDocSeries(docSeries);
		context.setDocNum(docNum);
		context.setDocDate(docDate);
		context.setDocIssued(docIssued);
		context.setEvDate(evDate);
		
		String expected = "SELECT e FROM Order e WHERE ( e.orderType = :orderType OR e.employee = :employee OR e.asset = :asset OR e.partner = :partner OR e.opType = :opType OR e.department = :department OR e.reason = :reason OR e.parent = :parent OR e.reasonText LIKE CONCAT('%',:reasonText,'%') OR e.docSeries LIKE CONCAT('%',:docSeries,'%') OR e.docNum LIKE CONCAT('%',:docNum,'%') OR e.docDate = :docDate OR e.docIssued LIKE CONCAT('%',:docIssued,'%') OR e.evDate = :evDate ) AND e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		MultiplePagedSearch<Order> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expected, actualQuery);
	}
	
	@Test
	public void testBuildWithParametersAndDisabledDefaultConstraints() throws Exception {
		// Given
		unit.setActive(false);
		unit.setSecurity(false);
		
		OrderType orderType = new OrderType();
		Employee employee = new Employee();
		Asset asset = new Asset();
		Partner partner = new Partner();
		OperationType opType = new OperationType();
		Department department = new Department();
		Reason reason = new Reason();
		Order parent = new Order();
		String reasonText = "fsdfsd";
		String docSeries = "fdsfds";
		String docNum = "fsdfds";
		Date docDate = new Date();
		String docIssued = "fdfds";
		Date evDate = new Date();
		
		Order context = new Order();
		context.setOrderType(orderType);
		context.setEmployee(employee);
		context.setAsset(asset);
		context.setPartner(partner);
		context.setOpType(opType);
		context.setDepartment(department);
		context.setReason(reason);
		context.setParent(parent);
		context.setReasonText(reasonText);
		context.setDocSeries(docSeries);
		context.setDocNum(docNum);
		context.setDocDate(docDate);
		context.setDocIssued(docIssued);
		context.setEvDate(evDate);
		
		String expected = "SELECT e FROM Order e WHERE ( e.orderType = :orderType OR e.employee = :employee OR e.asset = :asset OR e.partner = :partner OR e.opType = :opType OR e.department = :department OR e.reason = :reason OR e.parent = :parent OR e.reasonText LIKE CONCAT('%',:reasonText,'%') OR e.docSeries LIKE CONCAT('%',:docSeries,'%') OR e.docNum LIKE CONCAT('%',:docNum,'%') OR e.docDate = :docDate OR e.docIssued LIKE CONCAT('%',:docIssued,'%') OR e.evDate = :evDate ) ";
		MultiplePagedSearch<Order> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expected, actualQuery);
	}

}
