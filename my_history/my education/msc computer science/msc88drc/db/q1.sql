SELECT DISTINCT co.corder_no,co.iid,st.w_price, cd.r_price,co.cno_bought,cu.corder_date 
FROM corder_details as co, customer_order as cu, cd as cd, stock as st 
WHERE co.iid=cd.iid AND co.corder_no=cu.corder_no AND co.iid = st.iid AND 
corder_date > '2002-01-01';