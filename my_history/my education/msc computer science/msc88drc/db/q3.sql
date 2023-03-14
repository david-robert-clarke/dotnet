SELECT SUM(st.w_price) AS wholesale, SUM(cd.r_price) AS retail
FROM cd as cd, customer_order as cu, corder_details as co, stock as st
WHERE co.iid = cd.iid AND co.corder_no = cu.corder_no AND cd.iid = st.iid AND
cu.corder_date > '2003-01-01';