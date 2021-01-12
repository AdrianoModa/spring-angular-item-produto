import { Produto } from './../entity/produto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs/operators';

@Injectable()
export class ProdutoService {

  constructor(private httpCliente: HttpClient) { }

  produtoURL = 'http://localhost:8080/produto'

  getProdutos(){
    return this.httpCliente.get<any>(`${this.produtoURL}`).pipe(take(1))
  }

  getProdutosPorId(id: number) {
    return this.httpCliente.get<any>(`${this.produtoURL}/${id}`).pipe(take(1))
  }

  postProdutos(produto: any){
    return this.httpCliente.post(`${this.produtoURL}`, produto).pipe(take(1))
  }

  putProduto(produto: any){
    return this.httpCliente.put(`${this.produtoURL}/${produto.id}`, produto).pipe(take(1))
  }

  deleteProdutos(id: number) {
    return this.httpCliente.delete(`${this.produtoURL}/${id}`).pipe(take(1))
  }

}
