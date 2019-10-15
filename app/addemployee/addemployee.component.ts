import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Department } from '../department';
import { Job } from '../job';
import { EmployeeService } from '../employee.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit {
  employee = new Employee;
  departments: Department[];
  jobs: Job[];
  jcode: number;
  did: number;
  date = new Date;
  constructor(private _employeeService: EmployeeService, private router: Router,
    private _activatedRoute: ActivatedRoute) {
   }

  ngOnInit() {
    this._employeeService.getDepartments().subscribe(
      departments => { this.departments = departments; }
    );
    this._employeeService.getJobs().subscribe(
      jobs => { this.jobs = jobs; }
    );
    // const empCode = this._activatedRoute.snapshot.params['eid'];
    // this._employeeService.getEmployeeById(empCode)
    //     .subscribe((employeeData) => {
    //         if (employeeData == null) {
    //             this.statusMessage =
    //                 'Employee with the specified Employee Code does not exist';
    //         } else {
    //             this.employee = employeeData;
    //         }
    //     },
    //     (error) => {
    //         this.statusMessage =
    //             'Problem with the service. Please try again after sometime';
    //         console.error(error);
    //     });
  }

  addEmployee() {
    this.employee = {
    'eid': this.employee.eid,
    'ename': this.employee.ename,
    'salary': this.employee.salary,
    'doj': this.employee.doj,
    'dept': {
      'did': this.did,
      'dname': 'production',
      'loc':
        {
          'lid': 1,
          'lname': 'Mascot'
        }
    },
    'job':
        {
          'jcode': this.jcode,
          'jname': 'deve'
        },
    'bonus': this.employee.bonus
    };

    this._employeeService.addEmployee(this.employee).subscribe(
      data => {
        this.router.navigate(['/employees']);
      }, error => {
        alert(error);
      });

  }

}
