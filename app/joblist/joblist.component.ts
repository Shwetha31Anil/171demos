import { Component, OnInit } from '@angular/core';
import { Job } from '../job';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-joblist',
  templateUrl: './joblist.component.html',
  styleUrls: ['./joblist.component.css']
})
export class JoblistComponent implements OnInit {
  jobs: Job[];
  constructor(private _employeeService: EmployeeService) { }

  ngOnInit() {
    this._employeeService.getJobs().subscribe( jobs => {
      this.jobs = jobs;
    });
  }

}
