package cn.itcast.domain.cargo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOfferorIsNull() {
            addCriterion("offeror is null");
            return (Criteria) this;
        }

        public Criteria andOfferorIsNotNull() {
            addCriterion("offeror is not null");
            return (Criteria) this;
        }

        public Criteria andOfferorEqualTo(String value) {
            addCriterion("offeror =", value, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorNotEqualTo(String value) {
            addCriterion("offeror <>", value, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorGreaterThan(String value) {
            addCriterion("offeror >", value, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorGreaterThanOrEqualTo(String value) {
            addCriterion("offeror >=", value, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorLessThan(String value) {
            addCriterion("offeror <", value, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorLessThanOrEqualTo(String value) {
            addCriterion("offeror <=", value, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorLike(String value) {
            addCriterion("offeror like", value, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorNotLike(String value) {
            addCriterion("offeror not like", value, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorIn(List<String> values) {
            addCriterion("offeror in", values, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorNotIn(List<String> values) {
            addCriterion("offeror not in", values, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorBetween(String value1, String value2) {
            addCriterion("offeror between", value1, value2, "offeror");
            return (Criteria) this;
        }

        public Criteria andOfferorNotBetween(String value1, String value2) {
            addCriterion("offeror not between", value1, value2, "offeror");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNull() {
            addCriterion("contract_no is null");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNotNull() {
            addCriterion("contract_no is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("contract_no =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotEqualTo(String value) {
            addCriterion("contract_no <>", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThan(String value) {
            addCriterion("contract_no >", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("contract_no >=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThan(String value) {
            addCriterion("contract_no <", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThanOrEqualTo(String value) {
            addCriterion("contract_no <=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLike(String value) {
            addCriterion("contract_no like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotLike(String value) {
            addCriterion("contract_no not like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoIn(List<String> values) {
            addCriterion("contract_no in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotIn(List<String> values) {
            addCriterion("contract_no not in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoBetween(String value1, String value2) {
            addCriterion("contract_no between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotBetween(String value1, String value2) {
            addCriterion("contract_no not between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andSigningDateIsNull() {
            addCriterion("signing_date is null");
            return (Criteria) this;
        }

        public Criteria andSigningDateIsNotNull() {
            addCriterion("signing_date is not null");
            return (Criteria) this;
        }

        public Criteria andSigningDateEqualTo(Date value) {
            addCriterion("signing_date =", value, "signingDate");
            return (Criteria) this;
        }

        public Criteria andSigningDateNotEqualTo(Date value) {
            addCriterion("signing_date <>", value, "signingDate");
            return (Criteria) this;
        }

        public Criteria andSigningDateGreaterThan(Date value) {
            addCriterion("signing_date >", value, "signingDate");
            return (Criteria) this;
        }

        public Criteria andSigningDateGreaterThanOrEqualTo(Date value) {
            addCriterion("signing_date >=", value, "signingDate");
            return (Criteria) this;
        }

        public Criteria andSigningDateLessThan(Date value) {
            addCriterion("signing_date <", value, "signingDate");
            return (Criteria) this;
        }

        public Criteria andSigningDateLessThanOrEqualTo(Date value) {
            addCriterion("signing_date <=", value, "signingDate");
            return (Criteria) this;
        }

        public Criteria andSigningDateIn(List<Date> values) {
            addCriterion("signing_date in", values, "signingDate");
            return (Criteria) this;
        }

        public Criteria andSigningDateNotIn(List<Date> values) {
            addCriterion("signing_date not in", values, "signingDate");
            return (Criteria) this;
        }

        public Criteria andSigningDateBetween(Date value1, Date value2) {
            addCriterion("signing_date between", value1, value2, "signingDate");
            return (Criteria) this;
        }

        public Criteria andSigningDateNotBetween(Date value1, Date value2) {
            addCriterion("signing_date not between", value1, value2, "signingDate");
            return (Criteria) this;
        }

        public Criteria andInputByIsNull() {
            addCriterion("input_by is null");
            return (Criteria) this;
        }

        public Criteria andInputByIsNotNull() {
            addCriterion("input_by is not null");
            return (Criteria) this;
        }

        public Criteria andInputByEqualTo(String value) {
            addCriterion("input_by =", value, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByNotEqualTo(String value) {
            addCriterion("input_by <>", value, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByGreaterThan(String value) {
            addCriterion("input_by >", value, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByGreaterThanOrEqualTo(String value) {
            addCriterion("input_by >=", value, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByLessThan(String value) {
            addCriterion("input_by <", value, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByLessThanOrEqualTo(String value) {
            addCriterion("input_by <=", value, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByLike(String value) {
            addCriterion("input_by like", value, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByNotLike(String value) {
            addCriterion("input_by not like", value, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByIn(List<String> values) {
            addCriterion("input_by in", values, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByNotIn(List<String> values) {
            addCriterion("input_by not in", values, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByBetween(String value1, String value2) {
            addCriterion("input_by between", value1, value2, "inputBy");
            return (Criteria) this;
        }

        public Criteria andInputByNotBetween(String value1, String value2) {
            addCriterion("input_by not between", value1, value2, "inputBy");
            return (Criteria) this;
        }

        public Criteria andCheckByIsNull() {
            addCriterion("check_by is null");
            return (Criteria) this;
        }

        public Criteria andCheckByIsNotNull() {
            addCriterion("check_by is not null");
            return (Criteria) this;
        }

        public Criteria andCheckByEqualTo(String value) {
            addCriterion("check_by =", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByNotEqualTo(String value) {
            addCriterion("check_by <>", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByGreaterThan(String value) {
            addCriterion("check_by >", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByGreaterThanOrEqualTo(String value) {
            addCriterion("check_by >=", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByLessThan(String value) {
            addCriterion("check_by <", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByLessThanOrEqualTo(String value) {
            addCriterion("check_by <=", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByLike(String value) {
            addCriterion("check_by like", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByNotLike(String value) {
            addCriterion("check_by not like", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByIn(List<String> values) {
            addCriterion("check_by in", values, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByNotIn(List<String> values) {
            addCriterion("check_by not in", values, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByBetween(String value1, String value2) {
            addCriterion("check_by between", value1, value2, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByNotBetween(String value1, String value2) {
            addCriterion("check_by not between", value1, value2, "checkBy");
            return (Criteria) this;
        }

        public Criteria andInspectorIsNull() {
            addCriterion("inspector is null");
            return (Criteria) this;
        }

        public Criteria andInspectorIsNotNull() {
            addCriterion("inspector is not null");
            return (Criteria) this;
        }

        public Criteria andInspectorEqualTo(String value) {
            addCriterion("inspector =", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotEqualTo(String value) {
            addCriterion("inspector <>", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorGreaterThan(String value) {
            addCriterion("inspector >", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorGreaterThanOrEqualTo(String value) {
            addCriterion("inspector >=", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLessThan(String value) {
            addCriterion("inspector <", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLessThanOrEqualTo(String value) {
            addCriterion("inspector <=", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLike(String value) {
            addCriterion("inspector like", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotLike(String value) {
            addCriterion("inspector not like", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorIn(List<String> values) {
            addCriterion("inspector in", values, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotIn(List<String> values) {
            addCriterion("inspector not in", values, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorBetween(String value1, String value2) {
            addCriterion("inspector between", value1, value2, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotBetween(String value1, String value2) {
            addCriterion("inspector not between", value1, value2, "inspector");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andCrequestIsNull() {
            addCriterion("crequest is null");
            return (Criteria) this;
        }

        public Criteria andCrequestIsNotNull() {
            addCriterion("crequest is not null");
            return (Criteria) this;
        }

        public Criteria andCrequestEqualTo(String value) {
            addCriterion("crequest =", value, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestNotEqualTo(String value) {
            addCriterion("crequest <>", value, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestGreaterThan(String value) {
            addCriterion("crequest >", value, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestGreaterThanOrEqualTo(String value) {
            addCriterion("crequest >=", value, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestLessThan(String value) {
            addCriterion("crequest <", value, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestLessThanOrEqualTo(String value) {
            addCriterion("crequest <=", value, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestLike(String value) {
            addCriterion("crequest like", value, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestNotLike(String value) {
            addCriterion("crequest not like", value, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestIn(List<String> values) {
            addCriterion("crequest in", values, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestNotIn(List<String> values) {
            addCriterion("crequest not in", values, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestBetween(String value1, String value2) {
            addCriterion("crequest between", value1, value2, "crequest");
            return (Criteria) this;
        }

        public Criteria andCrequestNotBetween(String value1, String value2) {
            addCriterion("crequest not between", value1, value2, "crequest");
            return (Criteria) this;
        }

        public Criteria andCustomNameIsNull() {
            addCriterion("custom_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomNameIsNotNull() {
            addCriterion("custom_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomNameEqualTo(String value) {
            addCriterion("custom_name =", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotEqualTo(String value) {
            addCriterion("custom_name <>", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameGreaterThan(String value) {
            addCriterion("custom_name >", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameGreaterThanOrEqualTo(String value) {
            addCriterion("custom_name >=", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameLessThan(String value) {
            addCriterion("custom_name <", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameLessThanOrEqualTo(String value) {
            addCriterion("custom_name <=", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameLike(String value) {
            addCriterion("custom_name like", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotLike(String value) {
            addCriterion("custom_name not like", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameIn(List<String> values) {
            addCriterion("custom_name in", values, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotIn(List<String> values) {
            addCriterion("custom_name not in", values, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameBetween(String value1, String value2) {
            addCriterion("custom_name between", value1, value2, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotBetween(String value1, String value2) {
            addCriterion("custom_name not between", value1, value2, "customName");
            return (Criteria) this;
        }

        public Criteria andShipTimeIsNull() {
            addCriterion("ship_time is null");
            return (Criteria) this;
        }

        public Criteria andShipTimeIsNotNull() {
            addCriterion("ship_time is not null");
            return (Criteria) this;
        }

        public Criteria andShipTimeEqualTo(Date value) {
            addCriterion("ship_time =", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeNotEqualTo(Date value) {
            addCriterion("ship_time <>", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeGreaterThan(Date value) {
            addCriterion("ship_time >", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ship_time >=", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeLessThan(Date value) {
            addCriterion("ship_time <", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeLessThanOrEqualTo(Date value) {
            addCriterion("ship_time <=", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeIn(List<Date> values) {
            addCriterion("ship_time in", values, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeNotIn(List<Date> values) {
            addCriterion("ship_time not in", values, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeBetween(Date value1, Date value2) {
            addCriterion("ship_time between", value1, value2, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeNotBetween(Date value1, Date value2) {
            addCriterion("ship_time not between", value1, value2, "shipTime");
            return (Criteria) this;
        }

        public Criteria andImportNumIsNull() {
            addCriterion("import_num is null");
            return (Criteria) this;
        }

        public Criteria andImportNumIsNotNull() {
            addCriterion("import_num is not null");
            return (Criteria) this;
        }

        public Criteria andImportNumEqualTo(Long value) {
            addCriterion("import_num =", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumNotEqualTo(Long value) {
            addCriterion("import_num <>", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumGreaterThan(Long value) {
            addCriterion("import_num >", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumGreaterThanOrEqualTo(Long value) {
            addCriterion("import_num >=", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumLessThan(Long value) {
            addCriterion("import_num <", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumLessThanOrEqualTo(Long value) {
            addCriterion("import_num <=", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumIn(List<Long> values) {
            addCriterion("import_num in", values, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumNotIn(List<Long> values) {
            addCriterion("import_num not in", values, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumBetween(Long value1, Long value2) {
            addCriterion("import_num between", value1, value2, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumNotBetween(Long value1, Long value2) {
            addCriterion("import_num not between", value1, value2, "importNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodIsNull() {
            addCriterion("delivery_period is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodIsNotNull() {
            addCriterion("delivery_period is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodEqualTo(Date value) {
            addCriterion("delivery_period =", value, "deliveryPeriod");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodNotEqualTo(Date value) {
            addCriterion("delivery_period <>", value, "deliveryPeriod");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodGreaterThan(Date value) {
            addCriterion("delivery_period >", value, "deliveryPeriod");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_period >=", value, "deliveryPeriod");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodLessThan(Date value) {
            addCriterion("delivery_period <", value, "deliveryPeriod");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodLessThanOrEqualTo(Date value) {
            addCriterion("delivery_period <=", value, "deliveryPeriod");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodIn(List<Date> values) {
            addCriterion("delivery_period in", values, "deliveryPeriod");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodNotIn(List<Date> values) {
            addCriterion("delivery_period not in", values, "deliveryPeriod");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodBetween(Date value1, Date value2) {
            addCriterion("delivery_period between", value1, value2, "deliveryPeriod");
            return (Criteria) this;
        }

        public Criteria andDeliveryPeriodNotBetween(Date value1, Date value2) {
            addCriterion("delivery_period not between", value1, value2, "deliveryPeriod");
            return (Criteria) this;
        }

        public Criteria andOldStateIsNull() {
            addCriterion("old_state is null");
            return (Criteria) this;
        }

        public Criteria andOldStateIsNotNull() {
            addCriterion("old_state is not null");
            return (Criteria) this;
        }

        public Criteria andOldStateEqualTo(Integer value) {
            addCriterion("old_state =", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateNotEqualTo(Integer value) {
            addCriterion("old_state <>", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateGreaterThan(Integer value) {
            addCriterion("old_state >", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_state >=", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateLessThan(Integer value) {
            addCriterion("old_state <", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateLessThanOrEqualTo(Integer value) {
            addCriterion("old_state <=", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateIn(List<Integer> values) {
            addCriterion("old_state in", values, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateNotIn(List<Integer> values) {
            addCriterion("old_state not in", values, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateBetween(Integer value1, Integer value2) {
            addCriterion("old_state between", value1, value2, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateNotBetween(Integer value1, Integer value2) {
            addCriterion("old_state not between", value1, value2, "oldState");
            return (Criteria) this;
        }

        public Criteria andOutStateIsNull() {
            addCriterion("out_state is null");
            return (Criteria) this;
        }

        public Criteria andOutStateIsNotNull() {
            addCriterion("out_state is not null");
            return (Criteria) this;
        }

        public Criteria andOutStateEqualTo(Integer value) {
            addCriterion("out_state =", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateNotEqualTo(Integer value) {
            addCriterion("out_state <>", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateGreaterThan(Integer value) {
            addCriterion("out_state >", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_state >=", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateLessThan(Integer value) {
            addCriterion("out_state <", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateLessThanOrEqualTo(Integer value) {
            addCriterion("out_state <=", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateIn(List<Integer> values) {
            addCriterion("out_state in", values, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateNotIn(List<Integer> values) {
            addCriterion("out_state not in", values, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateBetween(Integer value1, Integer value2) {
            addCriterion("out_state between", value1, value2, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateNotBetween(Integer value1, Integer value2) {
            addCriterion("out_state not between", value1, value2, "outState");
            return (Criteria) this;
        }

        public Criteria andTradeTermsIsNull() {
            addCriterion("trade_terms is null");
            return (Criteria) this;
        }

        public Criteria andTradeTermsIsNotNull() {
            addCriterion("trade_terms is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTermsEqualTo(String value) {
            addCriterion("trade_terms =", value, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsNotEqualTo(String value) {
            addCriterion("trade_terms <>", value, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsGreaterThan(String value) {
            addCriterion("trade_terms >", value, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsGreaterThanOrEqualTo(String value) {
            addCriterion("trade_terms >=", value, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsLessThan(String value) {
            addCriterion("trade_terms <", value, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsLessThanOrEqualTo(String value) {
            addCriterion("trade_terms <=", value, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsLike(String value) {
            addCriterion("trade_terms like", value, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsNotLike(String value) {
            addCriterion("trade_terms not like", value, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsIn(List<String> values) {
            addCriterion("trade_terms in", values, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsNotIn(List<String> values) {
            addCriterion("trade_terms not in", values, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsBetween(String value1, String value2) {
            addCriterion("trade_terms between", value1, value2, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andTradeTermsNotBetween(String value1, String value2) {
            addCriterion("trade_terms not between", value1, value2, "tradeTerms");
            return (Criteria) this;
        }

        public Criteria andPrintStyleIsNull() {
            addCriterion("print_style is null");
            return (Criteria) this;
        }

        public Criteria andPrintStyleIsNotNull() {
            addCriterion("print_style is not null");
            return (Criteria) this;
        }

        public Criteria andPrintStyleEqualTo(String value) {
            addCriterion("print_style =", value, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleNotEqualTo(String value) {
            addCriterion("print_style <>", value, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleGreaterThan(String value) {
            addCriterion("print_style >", value, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleGreaterThanOrEqualTo(String value) {
            addCriterion("print_style >=", value, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleLessThan(String value) {
            addCriterion("print_style <", value, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleLessThanOrEqualTo(String value) {
            addCriterion("print_style <=", value, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleLike(String value) {
            addCriterion("print_style like", value, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleNotLike(String value) {
            addCriterion("print_style not like", value, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleIn(List<String> values) {
            addCriterion("print_style in", values, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleNotIn(List<String> values) {
            addCriterion("print_style not in", values, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleBetween(String value1, String value2) {
            addCriterion("print_style between", value1, value2, "printStyle");
            return (Criteria) this;
        }

        public Criteria andPrintStyleNotBetween(String value1, String value2) {
            addCriterion("print_style not between", value1, value2, "printStyle");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("stat is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("stat is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("stat =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("stat <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("stat >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("stat >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("stat <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("stat <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("stat in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("stat not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("stat between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("stat not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andProNumIsNull() {
            addCriterion("pro_num is null");
            return (Criteria) this;
        }

        public Criteria andProNumIsNotNull() {
            addCriterion("pro_num is not null");
            return (Criteria) this;
        }

        public Criteria andProNumEqualTo(Integer value) {
            addCriterion("pro_num =", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotEqualTo(Integer value) {
            addCriterion("pro_num <>", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumGreaterThan(Integer value) {
            addCriterion("pro_num >", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_num >=", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLessThan(Integer value) {
            addCriterion("pro_num <", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLessThanOrEqualTo(Integer value) {
            addCriterion("pro_num <=", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumIn(List<Integer> values) {
            addCriterion("pro_num in", values, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotIn(List<Integer> values) {
            addCriterion("pro_num not in", values, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumBetween(Integer value1, Integer value2) {
            addCriterion("pro_num between", value1, value2, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_num not between", value1, value2, "proNum");
            return (Criteria) this;
        }

        public Criteria andExtNumIsNull() {
            addCriterion("ext_num is null");
            return (Criteria) this;
        }

        public Criteria andExtNumIsNotNull() {
            addCriterion("ext_num is not null");
            return (Criteria) this;
        }

        public Criteria andExtNumEqualTo(Integer value) {
            addCriterion("ext_num =", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumNotEqualTo(Integer value) {
            addCriterion("ext_num <>", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumGreaterThan(Integer value) {
            addCriterion("ext_num >", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ext_num >=", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumLessThan(Integer value) {
            addCriterion("ext_num <", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumLessThanOrEqualTo(Integer value) {
            addCriterion("ext_num <=", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumIn(List<Integer> values) {
            addCriterion("ext_num in", values, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumNotIn(List<Integer> values) {
            addCriterion("ext_num not in", values, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumBetween(Integer value1, Integer value2) {
            addCriterion("ext_num between", value1, value2, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ext_num not between", value1, value2, "extNum");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIsNull() {
            addCriterion("create_dept is null");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIsNotNull() {
            addCriterion("create_dept is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDeptEqualTo(String value) {
            addCriterion("create_dept =", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotEqualTo(String value) {
            addCriterion("create_dept <>", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptGreaterThan(String value) {
            addCriterion("create_dept >", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptGreaterThanOrEqualTo(String value) {
            addCriterion("create_dept >=", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptLessThan(String value) {
            addCriterion("create_dept <", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptLessThanOrEqualTo(String value) {
            addCriterion("create_dept <=", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptLike(String value) {
            addCriterion("create_dept like", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotLike(String value) {
            addCriterion("create_dept not like", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIn(List<String> values) {
            addCriterion("create_dept in", values, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotIn(List<String> values) {
            addCriterion("create_dept not in", values, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptBetween(String value1, String value2) {
            addCriterion("create_dept between", value1, value2, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotBetween(String value1, String value2) {
            addCriterion("create_dept not between", value1, value2, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}