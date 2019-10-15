import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit {
employees: Employee[];
  constructor(private _employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
    this._employeeService.getEmployees().subscribe(
                        employees => {
                          this.employees = employees;
                        },
                        error => {
                          alert('No employees');
                        }
                        );
  }

}
