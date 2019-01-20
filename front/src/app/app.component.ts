import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  options = [
    {value: 0, viewValue: 'A'},
    {value: 10, viewValue: 'B'},
    {value: 20, viewValue: 'C'}
  ];
  
  displayedColumns: string[] = ['cliente', 'credito', 'risco', 'txJuros'];
  dataSource = [];

  data = {cliente: '', credito: 0, risco: 'A', txJuros: 0};

  private urlAPI = 'http://localhost:8080/clientes';

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.listar();
  }

  salvar() {
    console.log('execute salvar() => ');
    this.data.risco = this.options.find(opt => opt.value == this.data.txJuros).viewValue;
    /*this.dataSource.push(
      {cliente: this.data.cliente, credito: this.data.credito, risco: this.data.risco, txJuros: this.data.txJuros});*/
    this.http.post(this.urlAPI, {cliente: this.data}).subscribe(() => this.listar());
  }

  listar() {
    this.http.get(this.urlAPI)
             .subscribe((data:Array<{}>) => {this.dataSource = data});
  }
}
