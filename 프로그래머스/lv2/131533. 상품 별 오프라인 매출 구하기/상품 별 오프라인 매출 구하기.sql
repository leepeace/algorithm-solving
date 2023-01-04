SELECT p.PRODUCT_CODE, sum(o.sales_amount)*p.price as SALES
from product as p inner join offline_sale as o
on p.product_id = o.product_id
group by p.product_code
order by SALES desc, p.PRODUCT_CODE asc;