import 'server-only';
import { Standing, Team } from '../../../types';
import getStandings from './getStandings';

export default async function getTeams(): Promise<Team[]>{


// za pomoca getStandings czyli metody ktora pobiera info o meczach po ID Ligowych, pobieramy dane o druzynach 
    try{
        const standings: Standing[] = await getStandings();
        const teams: Team[] = [];
        
        for(const league of standings){
            for(const standing of league.league.standings){
                if(Array.isArray(standing)){
                    for(const team of standing){
                        teams.push(team)
                    }
                }
                else {
                    throw new Error("Invalid standings data");
                }
            }
        }

        return teams;
    }catch(error){
        console.log("Error occuerd while fetching teams: ", error);
        throw error;
    }

}