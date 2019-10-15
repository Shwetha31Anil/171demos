import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Location } from '../location';
import { Router } from '@angular/router';

@Component({
  selector: 'app-locationlist',
  templateUrl: './locationlist.component.html',
  styleUrls: ['./locationlist.component.css']
})
export class LocationlistComponent implements OnInit {

  locations: Location[];
  constructor(private _employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
    this._employeeService.getLocations().subscribe( locations => {
      this.locations = locations;
    });
  }

  delete(loc: Location): void {
    this._employeeService.deleteLocation(loc.lid).subscribe(data => {
      this.locations = this.locations.filter(u => u !== loc);
    });
  }
//  edit(loc: Location): void {
//   localStorage.setItem('editLocId', loc.lid.toString());
//   this.router.navigate(['/addLocation']);
//  }

}
