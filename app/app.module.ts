import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { JoblistComponent } from './joblist/joblist.component';
import { LocationlistComponent } from './locationlist/locationlist.component';
import { DepartmentlistComponent } from './departmentlist/departmentlist.component';
import { AddjobComponent } from './addjob/addjob.component';
import { AddlocationComponent } from './addlocation/addlocation.component';
import { AdddepartmentComponent } from './adddepartment/adddepartment.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';
import { EmployeelistComponent } from './employeelist/employeelist.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { EmployeeService } from './employee.service';
import { HomeComponent } from './home/home.component';

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'employees', component: EmployeelistComponent},
  {path: 'addEmployee', component: AddemployeeComponent},
  {path: 'editEmployee/:eid', component: AddemployeeComponent},
  {path: 'jobs', component: JoblistComponent},
  {path: 'addJob', component: AddjobComponent},
  {path: 'locations', component: LocationlistComponent},
  {path: 'addLocation', component: AddlocationComponent},
  {path: 'departments', component: DepartmentlistComponent },
  {path: 'addDepartment', component: AdddepartmentComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**' , component: PagenotfoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    JoblistComponent,
    LocationlistComponent,
    DepartmentlistComponent,
    AddjobComponent,
    AddlocationComponent,
    AdddepartmentComponent,
    AddemployeeComponent,
    PagenotfoundComponent,
    EmployeelistComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, RouterModule.forRoot(appRoutes)
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
