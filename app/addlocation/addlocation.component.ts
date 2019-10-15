import { Component, OnInit } from '@angular/core';
import { Location } from '../location';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addlocation',
  templateUrl: './addlocation.component.html',
  styleUrls: ['./addlocation.component.css']
})
export class AddlocationComponent implements OnInit {
location = new Location;
  constructor(private _employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
    // const lid = localStorage.getItem('editLocId');
    // const lid1 = +lid;
    // console.log(lid1);
    // if (!lid) {
    //   alert('Invalid action');
    //   this.router.navigate(['/locations']);
    //   return;
    // }
    //  this._employeeService.getLocationById(lid1).subscribe(data => {
    //    this.location = data;
    //  });
    //  console.log(this.location.lid);
  }

addLocation() {
console.log('location called');
this._employeeService.addLocation(this.location).subscribe(
  data => {
  this.router.navigate(['/locations']);
},
error => {
  alert(error);
});
  }
}
