SELECT DISTINCT cd.iid, st.w_price, cu.corder_date, co.cno_bought
FROM cd as cd, customer_order as cu, corder_details as co, stock as st
WHERE co.iid = cd.iid AND cd.iid = st.iid AND cd.iid = '000003'; 
