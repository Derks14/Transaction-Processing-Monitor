import {Component, OnInit} from '@angular/core';
import {ClientService, Driver, Insured, Migrant, Voter} from './client.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'TPM';
  list = [];
  driver: Driver[];
  insured: Insured[];
  migrant: Migrant[];
  voter: Voter[];
  ngOnInit(): void {
    console.log(this.getData.getAllDrivers());
  }

  constructor( public getData: ClientService) { }
  displayDrivers() {
    this.getData.getAllDrivers().subscribe(
      data => {
        console.log(data);
        this.driver = data;
        this.list = data;
      }
    );
  }
  displayInsured() {
    this.getData.getAllInsureds().subscribe(
      data => {
        console.log('Insured Received');
        this.insured = data;
        this.list = data;
      }
    );
  }
  displayMigrant() {
    this.getData.getAllMigrants().subscribe(
      data => {
        console.log('Migrants Received');
        this.migrant = data;
        this.list = data;
      }
    );
  }
  displayVoter() {
    this.getData.getAllVoters().subscribe(
      data => {
        console.log('Voters Received');
        this.voter = data;
        this.list = data;
      }
    );
  }

}
