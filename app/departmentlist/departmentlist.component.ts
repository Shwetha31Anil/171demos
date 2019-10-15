import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Department } from '../department';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-departmentlist',
  templateUrl: './departmentlist.component.html',
  styleUrls: ['./departmentlist.component.css']
})
export class DepartmentlistComponent implements OnInit {
 departments: Department[];
  constructor(private _employeeService: EmployeeService) { }

  ngOnInit() {
    this._employeeService.getDepartments().subscribe(
      departments => { this.departments = departments; }
    );
  }

}
