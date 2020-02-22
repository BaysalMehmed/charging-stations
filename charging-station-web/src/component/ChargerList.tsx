import React, { Component } from 'react'
import IMarkerWrapper from '../interface/IMarkerWrapper'
import { Grid, Paper } from '@material-ui/core'


interface IChargerWrapper {
    markersToRender: IMarkerWrapper[]
    onChargerListItemClick: Function
}

class ChargerList extends Component<IChargerWrapper> {

    render() {

        const { markersToRender, onChargerListItemClick } = this.props
        return (
            <Grid container spacing={3}>
                {
                    markersToRender.map(e => {
                        return <Grid item xs={6} >
                            <Paper style={{ cursor: 'pointer' }} onClick={() => onChargerListItemClick(e)}>{e.type} - {e.description}</Paper>
                        </Grid>
                    })
                }
            </Grid >
        )
    }
}

export default ChargerList