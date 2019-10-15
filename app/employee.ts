import { Department } from './department';
import { Job } from './job';
export class Employee {
    eid: number;
    ename: string;
    salary: number;
    doj: string;
    dept: Department;
    job: Job;
    bonus: number;
}
