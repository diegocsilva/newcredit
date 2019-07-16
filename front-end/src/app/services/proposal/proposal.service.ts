import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import { Observable } from 'rxjs';
import { Proposal } from '../../model/proposal.model';

@Injectable()
export class ProposalService {

  constructor(private http: HttpClient) {}

  create(proposal: Proposal){
    return this.http.post(`${environment.proposal.send}`, proposal);
  }

  findAllByCpf(cpf: number): Observable<Proposal[]> {
    return this.http.get<Proposal[]>(`${environment.proposal.findByCpf}/${cpf}`);
  }
}
