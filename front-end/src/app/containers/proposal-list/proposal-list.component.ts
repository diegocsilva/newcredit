import { Component, OnInit } from '@angular/core';
import { trigger, state, transition, style, animate } from '@angular/animations';
import { ProposalService } from '../../services/proposal/proposal.service';
import { ResponseProposta } from 'src/app/model/responseproposta.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import * as _ from 'lodash';

@Component({
  selector: 'app-proposal-list',
  templateUrl: './proposal-list.component.html',
  styleUrls: ['./proposal-list.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0', display: 'none' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})
export class ProposalListComponent implements OnInit {
  resposta: ResponseProposta;
  myForm: FormGroup;

  constructor(private proposalService: ProposalService,
    private toastr: ToastrService,
    private router: Router,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.initForm();
  }

  initForm(): void {
    this.myForm = this.formBuilder.group({
      cpf: ['', Validators.required]
    });
  }

  findResponseProposal() {
    if (!_.isUndefined(this.myForm)) {
      if (this.validForm()) {
        this.proposalService.findResponsePropostaByCpf(this.myForm.value.cpf).then(
          (response: ResponseProposta) => {
            this.resposta = response;
            console.log(this.resposta.status);
            this.resposta.status = this.resposta.status == 'APPROVED' ? 'Aceito' : 'Negado';
            this.toastr.success('Busca realizada com sucesso!');
          }, err => {
            const httpError: HttpErrorResponse = err;
            this.toastr.error(httpError.message);
          }
        );
      }
    }
  }

  validForm(): boolean {
    let valid = true;
    if (!this.nullOrEmpty(this.myForm.value.cpf)) {
      valid = false;
      this.toastr.error('O campo CPF deve ser preenchido!');
    }
    return valid;
  }

  nullOrEmpty(obj: any): boolean {
    return obj !== null && obj !== ''
  }

  resetForm(): void {
    this.myForm.patchValue({
      cpf: null
    });
  }

  cancel() {
    this.resetForm();
  }
}
