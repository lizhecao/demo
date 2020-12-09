package com.example.sharding_jdbc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
*
*  @author author
*/
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1607474209506L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long order_id;

    /**
    * 
    * isNullAble:0
    */
    private Integer user_id;

    /**
    * 
    * isNullAble:1
    */
    private String status;


    public void setOrder_id(Long order_id){this.order_id = order_id;}

    public Long getOrder_id(){return this.order_id;}

    public void setUser_id(Integer user_id){this.user_id = user_id;}

    public Integer getUser_id(){return this.user_id;}

    public void setStatus(String status){this.status = status;}

    public String getStatus(){return this.status;}
    @Override
    public String toString() {
        return "OrderEntity{" +
                "order_id='" + order_id + '\'' +
                "user_id='" + user_id + '\'' +
                "status='" + status + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private OrderEntity set;

        private ConditionBuilder where;

        public UpdateBuilder set(OrderEntity set){
            this.set = set;
            return this;
        }

        public OrderEntity getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends OrderEntity{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Long> order_idList;

        public List<Long> getOrder_idList(){return this.order_idList;}

        private Long order_idSt;

        private Long order_idEd;

        public Long getOrder_idSt(){return this.order_idSt;}

        public Long getOrder_idEd(){return this.order_idEd;}

        private List<Integer> user_idList;

        public List<Integer> getUser_idList(){return this.user_idList;}

        private Integer user_idSt;

        private Integer user_idEd;

        public Integer getUser_idSt(){return this.user_idSt;}

        public Integer getUser_idEd(){return this.user_idEd;}

        private List<String> statusList;

        public List<String> getStatusList(){return this.statusList;}


        private List<String> fuzzyStatus;

        public List<String> getFuzzyStatus(){return this.fuzzyStatus;}

        private List<String> rightFuzzyStatus;

        public List<String> getRightFuzzyStatus(){return this.rightFuzzyStatus;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder order_idBetWeen(Long order_idSt,Long order_idEd){
            this.order_idSt = order_idSt;
            this.order_idEd = order_idEd;
            return this;
        }

        public QueryBuilder order_idGreaterEqThan(Long order_idSt){
            this.order_idSt = order_idSt;
            return this;
        }
        public QueryBuilder order_idLessEqThan(Long order_idEd){
            this.order_idEd = order_idEd;
            return this;
        }


        public QueryBuilder order_id(Long order_id){
            setOrder_id(order_id);
            return this;
        }

        public QueryBuilder order_idList(Long ... order_id){
            this.order_idList = solveNullList(order_id);
            return this;
        }

        public QueryBuilder order_idList(List<Long> order_id){
            this.order_idList = order_id;
            return this;
        }

        public QueryBuilder fetchOrder_id(){
            setFetchFields("fetchFields","order_id");
            return this;
        }

        public QueryBuilder excludeOrder_id(){
            setFetchFields("excludeFields","order_id");
            return this;
        }

        public QueryBuilder user_idBetWeen(Integer user_idSt,Integer user_idEd){
            this.user_idSt = user_idSt;
            this.user_idEd = user_idEd;
            return this;
        }

        public QueryBuilder user_idGreaterEqThan(Integer user_idSt){
            this.user_idSt = user_idSt;
            return this;
        }
        public QueryBuilder user_idLessEqThan(Integer user_idEd){
            this.user_idEd = user_idEd;
            return this;
        }


        public QueryBuilder user_id(Integer user_id){
            setUser_id(user_id);
            return this;
        }

        public QueryBuilder user_idList(Integer ... user_id){
            this.user_idList = solveNullList(user_id);
            return this;
        }

        public QueryBuilder user_idList(List<Integer> user_id){
            this.user_idList = user_id;
            return this;
        }

        public QueryBuilder fetchUser_id(){
            setFetchFields("fetchFields","user_id");
            return this;
        }

        public QueryBuilder excludeUser_id(){
            setFetchFields("excludeFields","user_id");
            return this;
        }

        public QueryBuilder fuzzyStatus (List<String> fuzzyStatus){
            this.fuzzyStatus = fuzzyStatus;
            return this;
        }

        public QueryBuilder fuzzyStatus (String ... fuzzyStatus){
            this.fuzzyStatus = solveNullList(fuzzyStatus);
            return this;
        }

        public QueryBuilder rightFuzzyStatus (List<String> rightFuzzyStatus){
            this.rightFuzzyStatus = rightFuzzyStatus;
            return this;
        }

        public QueryBuilder rightFuzzyStatus (String ... rightFuzzyStatus){
            this.rightFuzzyStatus = solveNullList(rightFuzzyStatus);
            return this;
        }

        public QueryBuilder status(String status){
            setStatus(status);
            return this;
        }

        public QueryBuilder statusList(String ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public QueryBuilder statusList(List<String> status){
            this.statusList = status;
            return this;
        }

        public QueryBuilder fetchStatus(){
            setFetchFields("fetchFields","status");
            return this;
        }

        public QueryBuilder excludeStatus(){
            setFetchFields("excludeFields","status");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public OrderEntity build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Long> order_idList;

        public List<Long> getOrder_idList(){return this.order_idList;}

        private Long order_idSt;

        private Long order_idEd;

        public Long getOrder_idSt(){return this.order_idSt;}

        public Long getOrder_idEd(){return this.order_idEd;}

        private List<Integer> user_idList;

        public List<Integer> getUser_idList(){return this.user_idList;}

        private Integer user_idSt;

        private Integer user_idEd;

        public Integer getUser_idSt(){return this.user_idSt;}

        public Integer getUser_idEd(){return this.user_idEd;}

        private List<String> statusList;

        public List<String> getStatusList(){return this.statusList;}


        private List<String> fuzzyStatus;

        public List<String> getFuzzyStatus(){return this.fuzzyStatus;}

        private List<String> rightFuzzyStatus;

        public List<String> getRightFuzzyStatus(){return this.rightFuzzyStatus;}

        public ConditionBuilder order_idBetWeen(Long order_idSt,Long order_idEd){
            this.order_idSt = order_idSt;
            this.order_idEd = order_idEd;
            return this;
        }

        public ConditionBuilder order_idGreaterEqThan(Long order_idSt){
            this.order_idSt = order_idSt;
            return this;
        }
        public ConditionBuilder order_idLessEqThan(Long order_idEd){
            this.order_idEd = order_idEd;
            return this;
        }


        public ConditionBuilder order_idList(Long ... order_id){
            this.order_idList = solveNullList(order_id);
            return this;
        }

        public ConditionBuilder order_idList(List<Long> order_id){
            this.order_idList = order_id;
            return this;
        }

        public ConditionBuilder user_idBetWeen(Integer user_idSt,Integer user_idEd){
            this.user_idSt = user_idSt;
            this.user_idEd = user_idEd;
            return this;
        }

        public ConditionBuilder user_idGreaterEqThan(Integer user_idSt){
            this.user_idSt = user_idSt;
            return this;
        }
        public ConditionBuilder user_idLessEqThan(Integer user_idEd){
            this.user_idEd = user_idEd;
            return this;
        }


        public ConditionBuilder user_idList(Integer ... user_id){
            this.user_idList = solveNullList(user_id);
            return this;
        }

        public ConditionBuilder user_idList(List<Integer> user_id){
            this.user_idList = user_id;
            return this;
        }

        public ConditionBuilder fuzzyStatus (List<String> fuzzyStatus){
            this.fuzzyStatus = fuzzyStatus;
            return this;
        }

        public ConditionBuilder fuzzyStatus (String ... fuzzyStatus){
            this.fuzzyStatus = solveNullList(fuzzyStatus);
            return this;
        }

        public ConditionBuilder rightFuzzyStatus (List<String> rightFuzzyStatus){
            this.rightFuzzyStatus = rightFuzzyStatus;
            return this;
        }

        public ConditionBuilder rightFuzzyStatus (String ... rightFuzzyStatus){
            this.rightFuzzyStatus = solveNullList(rightFuzzyStatus);
            return this;
        }

        public ConditionBuilder statusList(String ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public ConditionBuilder statusList(List<String> status){
            this.statusList = status;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private OrderEntity obj;

        public Builder(){
            this.obj = new OrderEntity();
        }

        public Builder order_id(Long order_id){
            this.obj.setOrder_id(order_id);
            return this;
        }
        public Builder user_id(Integer user_id){
            this.obj.setUser_id(user_id);
            return this;
        }
        public Builder status(String status){
            this.obj.setStatus(status);
            return this;
        }
        public OrderEntity build(){return obj;}
    }

}
