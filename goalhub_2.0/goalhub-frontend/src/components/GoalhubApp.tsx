import { useState, useEffect } from 'react';
import axios from 'axios';

export default function GoalhubApp() {
  const [league, setLeague] = useState<
    'premier-league' | 'la-liga' | 'bundesliga' | 'ekstraklasa' | 'serie-a' | 'liga-mistrzow'
  >('premier-league');
  const [data, setData] = useState([]);
  const [showStandings, setShowStandings] = useState(true);
  const [matches, setMatches] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [originalData, setOriginalData] = useState([]);
  const [originalMatches, setOriginalMatches] = useState([]);
  const [showFavoritesOnly, setShowFavoritesOnly] = useState(false);
  const [favorites, setFavorites] = useState<string[]>(() => {
    if (typeof window !== 'undefined') {
      const saved = localStorage.getItem('favorites');
      return saved ? JSON.parse(saved) : [];
    }
    return [];
  });
  const [darkMode, setDarkMode] = useState(() => {
    if (typeof window !== 'undefined') {
      const savedMode = localStorage.getItem('theme');
      if (savedMode) return savedMode === 'dark';
      return window.matchMedia('(prefers-color-scheme: dark)').matches;
    }
    return true;
  });

  // Apply theme class and save preference
  useEffect(() => {
    if (darkMode) {
      document.documentElement.classList.add('dark');
      document.documentElement.classList.remove('light');
    } else {
      document.documentElement.classList.add('light');
      document.documentElement.classList.remove('dark');
    }
    localStorage.setItem('theme', darkMode ? 'dark' : 'light');
  }, [darkMode]);

  // Save favorites to localStorage
  useEffect(() => {
    localStorage.setItem('favorites', JSON.stringify(favorites));
  }, [favorites]);

  // Watch for system preference changes
  useEffect(() => {
    const mediaQuery = window.matchMedia('(prefers-color-scheme: dark)');
    const handleChange = (e: MediaQueryListEvent) => {
      if (!localStorage.getItem('theme')) {
        setDarkMode(e.matches);
      }
    };
    mediaQuery.addEventListener('change', handleChange);
    return () => mediaQuery.removeEventListener('change', handleChange);
  }, []);

  useEffect(() => {
    if (showStandings) {
      axios
        .get(`/api/${league}`)
        .then((res) => {
          setData(res.data);
          setOriginalData(res.data);
        })
        .catch((err) => console.error(err));
    } else {
      axios
        .get(`/api/matches/${league}`)
        .then((res) => {
          setMatches(res.data);
          setOriginalMatches(res.data);
        })
        .catch((err) => console.error(err));
    }
  }, [league, showStandings]);

  useEffect(() => {
    let filtered = showStandings ? [...originalData] : [...originalMatches];
    
    // Apply search filter
    if (searchTerm.trim() !== '') {
      const term = searchTerm.toLowerCase();
      filtered = filtered.filter((item: any) => 
        showStandings
          ? item.druzyna.toLowerCase().includes(term)
          : item.team1.toLowerCase().includes(term) || 
            item.team2.toLowerCase().includes(term)
      );
    }
    
    // Apply favorites filter for standings
    if (showStandings && showFavoritesOnly) {
      filtered = filtered.filter((team: any) => 
        favorites.includes(team.druzyna)
      );
    }
    
    // Apply favorites filter for matches
    if (!showStandings && showFavoritesOnly) {
      filtered = filtered.filter((match: any) => 
        favorites.includes(match.team1) || 
        favorites.includes(match.team2)
      );
    }
    
    showStandings ? setData(filtered) : setMatches(filtered);
  }, [searchTerm, showStandings, originalData, originalMatches, showFavoritesOnly, favorites]);

  const tabs = [
    { id: 'premier-league', name: 'Premier League' },
    { id: 'la-liga', name: 'La Liga' },
    { id: 'bundesliga', name: 'Bundesliga' },
    { id: 'ekstraklasa', name: 'Ekstraklasa' },
    { id: 'serie-a', name: 'Serie A' },
    { id: 'liga-mistrzow', name: 'Liga Mistrzow' }
  ];

  const toggleView = () => {
    setSearchTerm('');
    setShowStandings((prev) => {
      const next = !prev;
      if (next) {
        setData(originalData);
      } else {
        setMatches(originalMatches);
      }
      return next;
    });
  };

  const handleSearchChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setSearchTerm(e.target.value);
  };

  const toggleFavorite = (teamName: string) => {
    setFavorites(prev => 
      prev.includes(teamName) 
        ? prev.filter(name => name !== teamName) 
        : [...prev, teamName]
    );
  };

  return (
    <div className="min-h-screen flex flex-col bg-gray-50 text-gray-900 dark:bg-gradient-to-b dark:from-neutral-900 dark:to-black dark:text-white font-sans transition-colors duration-200">
      {/* Header */}
      <header className="bg-white border-b border-gray-200 shadow-md py-4 px-6 dark:bg-neutral-950 dark:border-white/10">
        <div className="max-w-6xl mx-auto flex justify-between items-center gap-4">
          <button 
            onClick={() => setDarkMode(!darkMode)}
            className="p-2 rounded-full hover:bg-gray-200 dark:hover:bg-gray-700 transition-colors"
            aria-label={darkMode ? 'Switch to light mode' : 'Switch to dark mode'}
          >
            {darkMode ? (
              <span className="text-yellow-300">☀️</span>
            ) : (
              <span className="text-gray-700">🌙</span>
            )}
          </button>
          
          <h1 className="text-2xl font-bold tracking-tight">⚽ GoalHub</h1>
          
          <div className="flex-1 max-w-md">
            <div className="flex items-center gap-2">
              <input
                type="text"
                placeholder="Search team..."
                value={searchTerm}
                onChange={handleSearchChange}
                className="w-full bg-gray-100 border border-gray-300 rounded-full px-4 py-2 text-gray-900 focus:outline-none focus:ring-2 focus:ring-emerald-500 focus:border-transparent dark:bg-neutral-800 dark:border-neutral-700 dark:text-white"
              />
            </div>
          </div>
          
          <button 
            onClick={toggleView}
            className={`rounded-full px-4 py-2 text-sm font-medium transition-all duration-300 ${
              showStandings 
                ? 'bg-green-600 hover:bg-green-700' 
                : 'bg-emerald-600 hover:bg-emerald-700'
            } text-white`}
          >
            {showStandings ? 'Show Matches' : 'Show Standings'}
          </button>
        </div>
      </header>

      {/* Main Content */}
      <main className="relative flex-grow py-10 px-4">
        <div className="absolute left-295 top-30">
          <button
                onClick={() => setShowFavoritesOnly(!showFavoritesOnly)}
                className={`rounded-full px-6 py-2.5 font-medium border transition-all duration-300 hover:scale-105 ${showFavoritesOnly ? 'text-yellow-400 bg-white text-black border-white shadow-md dark:bg-white dark:text-black' : 'hover:text-yellow-400'}`}              >
                ★ Favorites ★ 
          </button>
        </div>

        <div className="max-w-6xl mx-auto">
          <h2 className="text-center text-4xl font-bold mb-10 tracking-tight">
            {showStandings ? 'GoalHub Standings' : 'GoalHub Matches'}
          </h2>
          

          <div className="flex justify-between items-center mb-4">
            <div className="flex flex-wrap justify-center gap-3">
              {tabs.map((tab) => (
                <button
                  key={tab.id}
                  onClick={() => {
                    setLeague(tab.id as any);
                    setSearchTerm('');
                  }}
                  className={`rounded-full px-6 py-2.5 font-medium border transition-all duration-300 hover:scale-105 ${
                    league === tab.id
                      ? 'bg-white text-black border-white shadow-md dark:bg-white dark:text-black'
                      : 'bg-gray-200 text-gray-800 border-gray-300 hover:bg-gray-300 dark:bg-neutral-800 dark:text-white dark:border-neutral-700 dark:hover:bg-neutral-700'
                  }`}
                >
                  {tab.name}
                </button>
              ))}
            </div>
          </div>

          {showStandings ? (
            <div className="overflow-x-auto rounded-xl shadow-xl ring-1 ring-gray-200 bg-white dark:ring-white/10 dark:backdrop-blur-sm dark:bg-white/5">
              <table className="table-fixed w-full border-collapse text-sm">
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
                <thead className="bg-gray-100 text-gray-700 dark:bg-white/10 dark:text-gray-300">
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
                  {data.length > 0 ? (
                    data.map((team: any, index: number) => (
                      <tr
                        key={index}
                        className="border-b border-gray-200 hover:bg-gray-50 transition-colors duration-150 dark:border-white/10 dark:hover:bg-white/10"
                      >
                        <td className="px-6 py-3 font-mono text-sm text-gray-500 dark:text-gray-300 text-left">{team.pozycja}</td>
                        <td className="px-6 py-3 font-semibold whitespace-nowrap overflow-hidden text-ellipsis text-left">
                          <div className="flex items-center">
                            <span>{team.druzyna}</span>
                            <button 
                              onClick={(e) => {
                                e.stopPropagation();
                                toggleFavorite(team.druzyna);
                              }}
                              className="ml-2 focus:outline-none"
                              aria-label={favorites.includes(team.druzyna) ? 'Remove from favorites' : 'Add to favorites'}
                            >
                              {favorites.includes(team.druzyna) ? (
                                <span className="text-yellow-400">★</span>
                              ) : (
                                <span className="text-gray-400 hover:text-yellow-400">☆</span>
                              )}
                            </button>
                          </div>
                        </td>
                        <td className="px-4 text-center text-gray-500 dark:text-gray-200">{team.mecze}</td>
                        <td className="px-4 text-center text-green-600 dark:text-green-400">{team.zwyciestwa}</td>
                        <td className="px-4 text-center text-yellow-600 dark:text-yellow-300">{team.remisy}</td>
                        <td className="px-4 text-center text-red-600 dark:text-red-400">{team.porazki}</td>
                        <td className="px-4 text-center">{team.bramki_zdobyte}</td>
                        <td className="px-4 text-center">{team.bramki_stracone}</td>
                        <td className="px-4 text-center">{team.roznica_bramek}</td>
                        <td className="px-4 text-center font-bold">{team.punkty}</td>
                      </tr>
                    ))
                  ) : (
                    <tr>
                      <td colSpan={10} className="px-6 py-4 text-center text-gray-500 dark:text-gray-400">
                        {showFavoritesOnly
                          ? 'No favorite teams found'
                          : `No teams found matching "${searchTerm}"`}
                      </td>
                    </tr>
                  )}
                </tbody>
              </table>
            </div>
          ) : (
            <div className="overflow-x-auto rounded-xl shadow-xl ring-1 ring-gray-200 bg-white dark:ring-white/10 dark:backdrop-blur-sm dark:bg-white/5">
              <table className="table-fixed w-full border-collapse text-sm">
                <colgroup>
                  <col className="w-2/12" />
                  <col className="w-4/12" />
                  <col className="w-1/12" />
                  <col className="w-4/12" />
                  <col className="w-1/12" />
                </colgroup>
                <thead className="bg-gray-100 text-gray-700 dark:bg-white/10 dark:text-gray-300">
                  <tr>
                    <th className="px-6 py-4 text-left">Date</th>
                    <th className="px-6 py-4 text-right">Home Team</th>
                    <th className="px-4 py-4 text-center">Score</th>
                    <th className="px-6 py-4 text-left">Away Team</th>
                    <th className="px-4 py-4 text-center">Status</th>
                  </tr>
                </thead>
                <tbody>
                  {matches.length > 0 ? (
                    matches.map((match: any, index: number) => (
                      <tr
                        key={index}
                        className="border-b border-gray-200 hover:bg-gray-50 transition-colors duration-150 dark:border-white/10 dark:hover:bg-white/10"
                      >
                        <td className="px-6 py-3 text-gray-500 dark:text-gray-300">
                          {new Date(match.matchDate).toLocaleDateString()}
                        </td>
                        <td className="px-6 py-3 font-semibold text-right">
                          <div className="flex items-center justify-end">
                            <span>{match.team1}</span>
                            {favorites.includes(match.team1) && (
                              <span className="ml-1 text-yellow-400">★</span>
                            )}
                          </div>
                        </td>
                        <td className="px-4 text-center font-bold">
                          {match.team1_Goals !== null && match.team2_Goals !== null 
                            ? `${match.team1_Goals} - ${match.team2_Goals}`
                            : 'vs'}
                        </td>
                        <td className="px-6 py-3 font-semibold">
                          <div className="flex items-center">
                            {favorites.includes(match.team2) && (
                              <span className="mr-1 text-yellow-400">★</span>
                            )}
                            <span>{match.team2}</span>
                          </div>
                        </td>
                        <td className="px-4 text-center">
                          {match.team1_goals !== null && match.team2_goals !== null 
                            ? <span className="text-green-600 dark:text-green-400">Finished</span>
                            : <span className="text-yellow-600 dark:text-yellow-300">Upcoming</span>}
                        </td>
                      </tr>
                    ))
                  ) : (
                    <tr>
                      <td colSpan={5} className="px-6 py-4 text-center text-gray-500 dark:text-gray-400">
                        {showFavoritesOnly
                          ? 'No matches with favorite teams found'
                          : `No matches found for "${searchTerm}"`}
                      </td>
                    </tr>
                  )}
                </tbody>
              </table>
            </div>
          )}
        </div>
      </main>

      {/* Footer */}
      <footer className="bg-gray-100 text-gray-500 text-sm py-4 border-t border-gray-200 dark:bg-neutral-950 dark:text-gray-400 dark:border-white/10">
        <div className="max-w-6xl mx-auto px-6 text-center">
          &copy; {new Date().getFullYear()} GoalHub • Created by Adrian Bielenik, Kacper Kowalski, Szymon Kobyłka-Pilecki, Ksawery :) • All rights reserved.
        </div>
      </footer>
    </div>
  );
}