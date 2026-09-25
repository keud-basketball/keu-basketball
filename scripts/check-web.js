const fs = require('node:fs');

const html = fs.readFileSync('index.html', 'utf8');
const scriptMatch = html.match(/<script>([\s\S]*)<\/script>/);

if (!scriptMatch) {
  throw new Error('No inline application script found in index.html');
}

new Function(scriptMatch[1]);