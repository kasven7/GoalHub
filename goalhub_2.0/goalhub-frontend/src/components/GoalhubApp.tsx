import { useState, useEffect } from 'react';
import axios from 'axios';

export default function GoalhubApp() {
  const [league, setLeague] = useState<
    'premier-league' | 'laliga' | 'bundesliga' | 'ekstraklasa' | 'serie-a' | 'liga-mistrzow'
  >('premier-league');
  const [data, setData] = useState([]);
  const [showStandings, setShowStandings] = useState(true);
  const [matches, setMatches] = useState([]);

  useEffect(() => {
    if (showStandings) {
      axios
        .get(`/api/${league}`)
        .then((res) => setData(res.data))
        .catch((err) => console.error(err));
    } else {
      axios
        .get(`/api/matches`)
        .then((res) => setMatches(res.data))
        .catch((err) => console.error(err));
        console.log(matches);
    }
  }, [league, showStandings]);

  const tabs = [
    { id: 'premier-league', name: 'Premier League' },
    { id: 'laliga', name: 'LaLiga' },
    { id: 'bundesliga', name: 'Bundesliga' },
    { id: 'ekstraklasa', name: 'Ekstraklasa' },
    { id: 'serie-a', name: 'Serie A' },
    { id: 'liga-mistrzow', name: 'Liga Mistrzów' }
  ];

  const toggleView = () => {
    setShowStandings(!showStandings);
  };

  return (
    <div className="min-h-screen flex flex-col bg-gradient-to-b from-neutral-900 to-black text-white font-sans">
      {/* Header */}
      <header className="bg-neutral-950 border-b border-white/10 shadow-md py-4 px-6">
        <div className="max-w-6xl mx-auto flex justify-between items-center">
          <h1 className="text-2xl font-bold tracking-tight">⚽ GoalHub</h1>
          <button 
            onClick={toggleView}
            className={`rounded-full px-4 py-2 text-sm font-medium transition-all duration-300 ${
              showStandings 
                ? 'bg-green-600 hover:bg-green-700' 
                : 'bg-emerald-600 hover:bg-emerald-700'
            }`}
          >
            {showStandings ? 'Show Matches' : 'Show Standings'}
          </button>
        </div>
      </header>

      {/* Main Content */}
      <main className="flex-grow py-10 px-4">
        <div className="max-w-6xl mx-auto">
          <h2 className="text-center text-4xl font-bold mb-10 tracking-tight text-white drop-shadow">
            {showStandings ? 'GoalHub Standings' : 'GoalHub Matches'}
          </h2>

          <div className="flex flex-wrap justify-center gap-3 mb-10">
            {tabs.map((tab) => (
              <button
                key={tab.id}
                onClick={() => setLeague(tab.id as any)}
                className={`rounded-full px-6 py-2.5 font-medium border transition-all duration-300 hover:scale-105 ${
                  league === tab.id
                    ? 'bg-white text-black border-white shadow-md'
                    : 'bg-neutral-800 text-white border-neutral-700 hover:bg-neutral-700'
                }`}
              >
                {tab.name}
              </button>
            ))}
          </div>

          {showStandings ? (
            <div className="overflow-x-auto rounded-xl shadow-xl ring-1 ring-white/10 backdrop-blur-sm bg-white/5">
              <table className="table-fixed w-full border-collapse text-sm text-white">
                <colgroup>
                  <col className="w-1/12" />
                  <col className="w-3/12" />
                  <col className="w-1/12" />
                  <col className="w-1/12" />
                  <col className="w-1/12" />
                  <col className="w-1/12" />
                  <col className="w-1/12" />
                  <col className="w-1/12" />
                  <col className="w-1/12" />
                  <col className="w-1/12" />
                </colgroup>
                <thead className="bg-white/10 text-gray-300">
                  <tr>
                    <th className="px-6 py-4 text-left">Pos</th>
                    <th className="px-6 py-4 text-left">Team</th>
                    <th className="px-4 py-4 text-center">M</th>
                    <th className="px-4 py-4 text-center">W</th>
                    <th className="px-4 py-4 text-center">D</th>
                    <th className="px-4 py-4 text-center">L</th>
                    <th className="px-4 py-4 text-center">F</th>
                    <th className="px-4 py-4 text-center">A</th>
                    <th className="px-4 py-4 text-center">GD</th>
                    <th className="px-4 py-4 text-center">Pts</th>
                  </tr>
                </thead>
                <tbody>
                  {data.map((team: any, index: number) => (
                    <tr
                      key={index}
                      className="border-b border-white/10 hover:bg-white/10 transition-colors duration-150"
                    >
                      <td className="px-6 py-3 font-mono text-sm text-gray-300 text-left">{team.pozycja}</td>
                      <td className="px-6 py-3 font-semibold whitespace-nowrap overflow-hidden text-ellipsis text-left">
                        {team.druzyna}
                      </td>
                      <td className="px-4 text-center text-gray-200">{team.mecze}</td>
                      <td className="px-4 text-center text-green-400">{team.zwyciestwa}</td>
                      <td className="px-4 text-center text-yellow-300">{team.remisy}</td>
                      <td className="px-4 text-center text-red-400">{team.porazki}</td>
                      <td className="px-4 text-center">{team.bramki_zdobyte}</td>
                      <td className="px-4 text-center">{team.bramki_stracone}</td>
                      <td className="px-4 text-center">{team.roznica_bramek}</td>
                      <td className="px-4 text-center font-bold">{team.punkty}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          ) : (
            <div className="overflow-x-auto rounded-xl shadow-xl ring-1 ring-white/10 backdrop-blur-sm bg-white/5">
              <table className="table-fixed w-full border-collapse text-sm text-white">
                <colgroup>
                  <col className="w-2/12" />
                  <col className="w-4/12" />
                  <col className="w-1/12" />
                  <col className="w-4/12" />
                  <col className="w-1/12" />
                </colgroup>
                <thead className="bg-white/10 text-gray-300">
                  <tr>
                    <th className="px-6 py-4 text-left">Date</th>
                    <th className="px-6 py-4 text-right">Home Team</th>
                    <th className="px-4 py-4 text-center">Score</th>
                    <th className="px-6 py-4 text-left">Away Team</th>
                    <th className="px-4 py-4 text-center">Status</th>
                  </tr>
                </thead>
                <tbody>
                  {matches.map((match: any, index: number) => (
                    <tr
                      key={index}
                      className="border-b border-white/10 hover:bg-white/10 transition-colors duration-150"
                    >
                      <td className="px-6 py-3 text-gray-300">
                        {new Date(match.matchDate).toLocaleDateString()}
                      </td>
                      <td className="px-6 py-3 font-semibold text-right">
                        {match.team1}
                      </td>
                      <td className="px-4 text-center font-bold">
                        {match.team1_Goals !== null && match.team2_Goals !== null 
                          ? `${match.team1_Goals} - ${match.team2_Goals}`
                          : 'vs'}
                      </td>
                      <td className="px-6 py-3 font-semibold">
                        {match.team2}
                      </td>
                      <td className="px-4 text-center">
                        {match.team1_goals !== null && match.team2_goals !== null 
                          ? <span className="text-green-400">Finished</span>
                          : <span className="text-yellow-300">Upcoming</span>}
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </div>
      </main>

      {/* Footer */}
      <footer className="bg-neutral-950 text-gray-400 text-sm py-4 border-t border-white/10">
        <div className="max-w-6xl mx-auto px-6 text-center">
          &copy; {new Date().getFullYear()} GoalHub • Created by Adrian Bielenik, Kacper Kowalski, Szymon Kobyłka-Pilecki, Ksawery :) • All rights reserved.
        </div>
      </footer>
    </div>
  );
}