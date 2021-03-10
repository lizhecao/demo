create table t_order (
 id bigint not null primary key auto_increment,
 order_id bigint comment '业务方订单号（业务方系统唯一）',
 trade_type varchar (30) comment '业务交易类型，例如topup-表示钱包充值',
 amount bigint comment '交易金额，以分为单位',
 currency varchar (10) comment '币种，cny-人民币',
 status varchar (2) comment '支付状态，0-待支付；1-支付中；2-支付成功；3-支付失败',
 channel varchar (10) comment '支付渠道编码，0-微信支付，1-支付宝支付',
 trade_no varchar (32) comment '支付渠道流水号',
 user_id bigint (60) comment '业务方用户id',
 update_time timestamp null default current_timestamp on update current_timestamp comment '最后一次更新时间',
 create_time timestamp null default current_timestamp comment '交易创建时间',
 remark varchar(128)  comment '订单备注信息',
 unique key unique_idx_pay_id ( order_id ),
 key idx_user_id ( user_id ),
 key idx_create_time ( create_time )
) comment '交易订单表';

