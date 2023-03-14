select sod.sorder_no, sid, sorder_date, supid, iid, sno_bought
from staff_order AS so, sorder_details AS sod
where so.sorder_no = sod.sorder_no AND so.sorder_no = '000017'; 
