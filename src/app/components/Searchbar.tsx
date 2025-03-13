//Górna stopka 


import { Team } from "../../../types";
import getTeams from "../util/getTeams";
import SearchBarform from "./SerchBarform";

export default async function Searchbar(){

    let teamsData: Team[] = await getTeams();

    return (
        <div className="flex justify-center items-center w-full p-3 bg-black/40">
            <div className="w-1/6 flex justify-center items-center text-neutral-100">
                <a
                    href={"/"}
                    className="flex justify-center items-center"
                >
                    <div className="px-2 md:block hidden font-bold text-xl">
                        Aplikacja football
                    </div>
                </a>
            </div>
                    {/* Umieszczenie paska wyszukiwan */}
            <div className="w-4/6 flex justify-center items-center">
                <SearchBarform teamsData = {teamsData}/>
            </div>
            <div className="w-1/6"></div>
        </div>
    )
}