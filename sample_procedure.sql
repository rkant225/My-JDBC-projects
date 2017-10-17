DELIMITER //
create procedure increase_salary_of_department_temp(IN sal DECIMAL(10,2),IN dep VARCHAR(64))
begin
update employees set salary=salary+sal where department=dep;
end
//
