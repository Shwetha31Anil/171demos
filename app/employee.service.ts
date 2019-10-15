import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Location } from './location';
import { Observable } from 'rxjs';
import { Job } from './job';
import { Department } from './department';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  headers = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
};
  constructor(private _http: HttpClient) { }
  baseUrl = 'http://localhost:8089/SpringWithER/locations';
  addLocation(location: Location) {
    console.log(location);
    return this._http.post(this.baseUrl,
    JSON.stringify(location), this.headers);
  }
  deleteLocation(lid: number) {
    return this._http.delete(`http://localhost:8089/SpringWithER/location/` + lid);
  }
  updateLocation(location: Location) {
    return this._http.put(this.baseUrl,
      JSON.stringify(location), this.headers);
  }

  getLocationById(lid: number): Observable<Location> {
return this._http.get<Location>(`` + lid);
  }

  getEmployeesLocationById(lid: number): Observable<Employee[]> {
    console.log('service ' + lid);
  return this._http.get<Employee[]>(`http://localhost:8089/SpringWithER/employeesl/` + lid);
  }

  getLocations(): Observable<Location[]> {
    console.log('service for getlocation');
   return this._http.get<Location[]>('http://localhost:8089/SpringWithER/locations');
  }

  getJobs(): Observable<Job[]> {
    return this._http.get<Job[]>('http://localhost:8089/SpringWithER/jobs');
  }

  addJob(job: Job) {
    console.log(job);
    return this._http.post('http://localhost:8089/SpringWithER/jobs',
    JSON.stringify(job), this.headers);
  }

  getDepartments(): Observable<Department[]> {
    return this._http.get<Department[]>('http://localhost:8089/SpringWithER/departments');
  }

  addDepartment(department: Department) {
    console.log(department);
    return this._http.post('http://localhost:8089/SpringWithER/departments',
    JSON.stringify(department), this.headers);
  }

  getEmployees(): Observable<Employee[]> {
    return this._http.get<Employee[]>('http://localhost:8089/SpringWithER/employees');
  }


  addEmployee(employee: Employee) {
    console.log(employee);
    return this._http.post('http://localhost:8089/SpringWithER/employees',
    JSON.stringify(employee), this.headers);
  }

  getEmployeeById(eid: number) {
    return this._http.get(`` + eid);
  }
}
