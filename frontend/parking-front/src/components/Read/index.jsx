import React, { useEffect, useState } from 'react';
import { Button, Table } from 'semantic-ui-react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { BASE_URL } from '../utils/request';

export default function Read() {

    const [APIData, setAPIData] = useState([]);
    useEffect(() => {
        axios.get(`${BASE_URL}/usuarios`)
            .then((response) => {
                setAPIData(response.data);
            })
    }, [])

    const setData = (data) => {
        let { id, nome, email, cpf, dataNascimento } = data;
        localStorage.setItem('id', id);
        localStorage.setItem('nome', nome);
        localStorage.setItem('email', email);
        localStorage.setItem('cpf', cpf);
        localStorage.setItem('dataNascimento', dataNascimento)
    }

    return (
        <div>
            <Table singleLine>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell >Nome</Table.HeaderCell>
                        <Table.HeaderCell>E-mail</Table.HeaderCell>
                        <Table.HeaderCell >CPF</Table.HeaderCell>
                        <Table.HeaderCell colSpan='1'>Data de Nascimento</Table.HeaderCell>
                        <Table.HeaderCell> Cadastrar Veiculos</Table.HeaderCell>
                        <Table.HeaderCell> Visualizar veiculos</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>

                <Table.Body>

                    {APIData.map((data) => (
                        <Table.Row>
                            <Table.Cell> {data.nome} </Table.Cell>
                            <Table.Cell> {data.email} </Table.Cell>
                            <Table.Cell> {data.cpf} </Table.Cell>
                            <Table.Cell> {data.dataNascimento} </Table.Cell>
                            <Table.Cell>
                                <Link to='/createvehicle'>
                                    <Button onClick={() => setData(data)}>Cadastrar</Button>
                                </Link>
                            </Table.Cell>


                            <Table.Cell>
                                <Link to='/readvehicle'>
                                    <Button onClick={() => setData(data)}>Visualizar</Button>
                                </Link>
                            </Table.Cell>
                        </Table.Row>
                    ))}

                </Table.Body>
            </Table>
            
        </div>
    )
}