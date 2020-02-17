import React, { Component } from 'react'

interface ISpace {
    totalSpaces: number
    usedSpaces: number
}

class Spaces extends Component<ISpace> {

    drawSpaces(totalSpaces: number, usedSpaces: number): {image: any, alt: string}[] {

        let spacesString = [];
        for (let i = 1; i <= totalSpaces; i++) {
            if (i <= usedSpaces) {
                spacesString.push({image: require('../icons/spaceMarkers/full.png'), alt: 'Full'})
            } else {
                spacesString.push({image: require('../icons/spaceMarkers/empty.png'), alt: 'Empty'})
            }
        }
        return spacesString;
    }

    render() {
        const { totalSpaces, usedSpaces } = this.props;
        return (
            <div>
                <b>Spaces: </b> {this.drawSpaces(totalSpaces, usedSpaces).map((space, index) =>
                    <img key={index} src={space.image} alt={space.alt} />)}    
            </div>
        )
    }
}

export default Spaces