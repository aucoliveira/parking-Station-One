import React, { useEffect, useState } from 'react';
import { Table } from 'semantic-ui-react';
import axios from 'axios';



export default function ReadVehicle() {
    
    const [id, setID] = useState();
    const [nome, setNome] = useState();

    useEffect(() => {
        setID(localStorage.getItem('id'));
        setNome(localStorage.getItem('nome'));

    }, [])

    const [APIData, setAPIData] = useState([]);
    useEffect(() => {
        axios.get(`http://localhost:8080/usuarios/${id}/veiculos`)
            .then((response) => {
                setAPIData(response.data);
            })
            console.log("o id é: " + id)
    }, [id])

    

    return (

        <div>
            <h3>Listagem de veiculos de um usuário</h3>
            <p>Nome do Usuário: {nome}</p>
            <Table singleLine>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Marca</Table.HeaderCell>
                        <Table.HeaderCell>Modelo</Table.HeaderCell>
                        <Table.HeaderCell>Ano</Table.HeaderCell>                        
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {APIData.map((data) => {
                        return (
                            <Table.Row>
                                <Table.Cell>{data.marca}</Table.Cell>
                                <Table.Cell>{data.modelo}</Table.Cell>
                                <Table.Cell>{data.ano}</Table.Cell>
                               
                            </Table.Row>
                        )
                    })}
                </Table.Body>
            </Table>
        </div>
    )
}