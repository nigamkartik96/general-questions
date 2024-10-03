class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final Map<String, Set<Integer>> emailMapping = new HashMap<>();
        for (int j = 0; j < accounts.size(); j++) {
            List<String> account = accounts.get(j);
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                Set<Integer> names = emailMapping.getOrDefault(account.get(i), new TreeSet<>());
                names.add(j);
                emailMapping.put(account.get(i), names);
            }
        }

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < accounts.size(); i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (Map.Entry<String, Set<Integer>> entry : emailMapping.entrySet()) {
            Set<Integer> names = entry.getValue();
            for (Integer neighbour1 : names) {
                for (Integer neighbour2 : names) {
                    if (neighbour1 != neighbour2 && !adjacencyList.get(neighbour1).contains(neighbour2)) {
                        adjacencyList.get(neighbour1).add(neighbour2);
                        adjacencyList.get(neighbour2).add(neighbour1);
                    }
                }
            }
        }
        
        List<List<Integer>> paths = new ArrayList<>();

        boolean[] visited = new boolean[accounts.size()];
        for (int i = 0; i < accounts.size(); i ++) {
            if (!visited[i]) {
                List<Integer> path = new ArrayList<>();
                visited[i] = true;
                path.add(i);
                dfs(path, adjacencyList, i, visited);
                paths.add(path);
            }
        }

        return merge(paths, accounts);
    }

    
    private void dfs(List<Integer> path, List<List<Integer>> adjacencyList, int node, boolean[] visited) {
        if (adjacencyList.get(node).isEmpty()) {
            return;
        }

        for (int i : adjacencyList.get(node)) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(i);
                dfs(path, adjacencyList, i, visited);
            }
        }
    }

    private List<List<String>> merge(List<List<Integer>> paths, List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> path : paths) {
            Set<String> emails = new TreeSet<>();
            List<String> name = new ArrayList<>();
            for (Integer i : path) {
                List<String> account = accounts.get(i);
                if (name.isEmpty())
                    name.add(account.getFirst());
                for (int j = 1; j < account.size(); j++) {
                    emails.add(account.get(j));
                }
            }
            name.addAll(emails);
            result.add(name);
        }
        return result;
    }
}