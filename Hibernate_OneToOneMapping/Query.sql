drop table if exists Employee;
drop table if exists Vehicle;
create table Employee (
       empId integer not null auto_increment,
        empName varchar(255),
        emp_vehicleId integer,
        primary key (empId)
    );
create table Vehicle (
       vehicleId integer not null auto_increment,
        vehicleNumber varchar(255),
        vehicleType varchar(255),
        primary key (vehicleId)
    );
ALTER TABLE Vehicle AUTO_INCREMENT = 100;

alter table Employee 
    add constraint FK2f5i24qovm9pvywkarpmioraw 
    foreign key (emp_vehicleId) 
    references Vehicle (vehicleId);