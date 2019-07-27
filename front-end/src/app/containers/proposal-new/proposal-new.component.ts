import { Component, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ProposalService } from 'src/app/services/proposal/proposal.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import * as _ from 'lodash';
import { Proposal } from 'src/app/model/proposal.model';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-proposal-new',
  templateUrl: './proposal-new.component.html',
  styleUrls: ['./proposal-new.component.css']
})
export class ProposalNewComponent implements OnInit {

  myForm: FormGroup;
  maritals = [
    { name: 'Solteiro(a)', value: 'SINGLE' },
    { name: 'Casado(a)', value: 'MARRIED' },
    { name: 'Divorciado(a)', value: 'DIVORCED' },
    { name: 'Viúvo(a)', value: 'WIDOW' }
  ];

  constructor(
    private toastr: ToastrService,
    private proposalService: ProposalService,
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    this.initForm();
  }

  initForm(): void {
    this.myForm = this.formBuilder.group({
      name: ['', Validators.required],
      cpf: ['', Validators.required],
      sex: ['', Validators.required],
      age: ['', Validators.required],
      maritalStatus: ['', Validators.required],
      dependents: [0, Validators.required],
      income: ['', Validators.required],
    });
  }


  saveProposal() {
    if (!_.isUndefined(this.myForm)) {
      if (this.validForm()) {
        this.proposalService.create(this.myForm.value).subscribe(
          (response: any) => {
            this.myForm.reset();
            this.router.navigate(['proposal']);
            this.toastr.success('Proposta cadastrada com sucesso!');
          },
          err => {
            const httpError: HttpErrorResponse = err;
            this.toastr.error(httpError.message);
          }
        );
      }
    }
  }

  validForm(): boolean {
    let valid = true;
    if (!this.nullOrEmpty(this.myForm.value.name)) {
      valid = false;
      this.toastr.error('O campo Nome deve ser preenchido!');
    }
    if (!this.nullOrEmpty(this.myForm.value.cpf)) {
      valid = false;
      this.toastr.error('O campo CPF deve ser preenchido!');
    }
    if (!this.nullOrEmpty(this.myForm.value.maritalStatus)) {
      valid = false;
      this.toastr.error('O campo Estado Cívil deve ser preenchido!');
    }
    if (!this.nullOrEmpty(this.myForm.value.sex)) {
      valid = false;
      this.toastr.error('O campo Sexo deve ser preenchido!');
    }
    if (!this.nullOrEmpty(this.myForm.value.age)) {
      valid = false;
      this.toastr.error('O campo Idade deve ser preenchido!');
    }
    if (!this.nullOrEmpty(this.myForm.value.dependents)) {
      valid = false;
      this.toastr.error('O campo Dependentes deve ser preenchido!');
    }
    if (!this.nullOrEmpty(this.myForm.value.income)) {
      valid = false;
      this.toastr.error('O campo Renda deve ser preenchido!');
    }
    return valid;
  }

  nullOrEmpty(obj: any) : boolean{
    return obj !== null && obj !== ''
  }

  resetForm(): void {
    this.myForm.patchValue({
      name: null,
      cpf: null,
      sex: null,
      maritalStatus: null,
      dependents: null,
      income: null,
    });
  }
  cancel() {
    this.resetForm();
    this.toastr.info('Campos limpos com sucesso!');
  }
}
