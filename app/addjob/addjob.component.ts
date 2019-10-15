import { Component, OnInit } from '@angular/core';
import { Job } from '../job';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addjob',
  templateUrl: './addjob.component.html',
  styleUrls: ['./addjob.component.css']
})
export class AddjobComponent {
  job = new Job;
  constructor(private _employeeService: EmployeeService, private router: Router) { }
  addJob() {
    this._employeeService.addJob(this.job).subscribe(
      data => { this.router.navigate(['/jobs']);
    }, error => {
      alert(error);
    });
  }

}
