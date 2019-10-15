import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { Location } from '../location';
import { Department } from '../department';


@Component({
  selector: 'app-adddepartment',
  templateUrl: './adddepartment.component.html',
  styleUrls: ['./adddepartment.component.css']
})
export class AdddepartmentComponent implements OnInit {

  locations: Location[];
  department = new Department;
  lid: number;
  constructor(private _employeeService: EmployeeService,
    private _router: Router) { }

  ngOnInit() {
    this._employeeService.getLocations().subscribe( locations => {
      this.locations = locations;
    }, error => { alert(error); }
    );
  }

  addDepartment() {
    console.log(this.lid);
    this.department = {
      'did': this.department.did,
      'dname': this.department.dname,
      'loc':
      {
        'lid': this.lid,
        'lname': 'testing'
      }
    };
    this._employeeService.addDepartment(this.department).subscribe(
      data => {
        this._router.navigate(['/departments']);
      }, error => {
        alert(error);
      });
  }
}
