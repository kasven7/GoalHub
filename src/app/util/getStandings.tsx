
import 'server-only';
import { Standing } from "../../../types";
import moment from "moment";
import { USE_SAMPLE } from '../sampleData/useSample';
import getStandingsSample from '../sampleData/getStandingsSample';


export default async function getStandings():Promise<Standing[]> {

//  jezeli USE_SAMPLE true to nie bedzie zasysac niepotrzebnie danych z API
    if(USE_SAMPLE){
        return getStandingsSample();
    }


    // pobieranie czasu do konkretnego sezonu  
    const currentTime = moment();
    const month = currentTime.month();
    let year;

    if(month < 6 ){
        year = currentTime.year() - 1;
    }else{
        year = currentTime.year();
    }

    // inicjalizacja API 
    const API_KEY: string = process.env.API_KEY as string;
    const options = {
        method: 'GET',
	headers: {
		'x-rapidapi-key': API_KEY,
		'x-rapidapi-host': 'api-football-v1.p.rapidapi.com'
    },
    next: {
        // revalidate zeby się odnawiało
        revalidate: 60*60*24
    }
};


// szablon dzieki ktoremu przechwytujemy dane o meczach (standing) na podstawie lig i ID tych lig
// 
    const standings: Standing[] = [];

    const leagues = [
        {name:'EPL', id: 39},
        {name:'La Liga', id:140},
        {name:'Bundesliga', id:78},
        {name:'Serie A', id:135},
        {name:'Ligue1', id:61},
        ]
        for(const league of leagues){
        let url = `https://api-football-v1.p.rapidapi.com/v3/standings?league=${league.id}&season=${year}`

        await fetch(url, options)
        .then(response => response.json())
        .then(data =>{
            const standing = data.response[0];
            if(standing){
                standings.push(standing);
            }
        })
        .catch(err =>{
            console.error(`Error fetching ${league.name} standings ${err}`);
        })
        }
        return standings;
}