import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import { Observable } from 'rxjs';
import { Proposal } from '../../model/proposal.model';
import { ResponseProposta } from 'src/app/model/responseproposta.model';

@Injectable()
export class ProposalService {

  constructor(private http: HttpClient) {}

  create(proposal: Proposal){
    return this.http.post(`${environment.proposal.send}`, proposal);
  }

  findResponsePropostaByCpf(cpf: number): any {
    return this.http.get(`${environment.proposal.findByCpf}/${cpf}`).toPromise();
  }
}
